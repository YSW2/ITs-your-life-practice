// 🐾 시스템 사용 예시
class Item {
  constructor(name, type, stock) {
    this.name = name;
    this.type = type;
    this.stock = stock;
    this.alreadyWarned = false;
  }
}

class InventoryManager {
  constructor() {
    this.inventory = [];
  }
  addItem(item) {
    this.inventory.push(item);
    console.log(`[추가] ${item.type} - ${item.name} (재고: ${item.stock}개)`);
  }
  updateStock(name, newStock) {
    if (newStock < 0) {
      console.log('[업데이트 오류] 재고는 0 이상이어야 합니다.');
      return;
    }
    const targetItem = this.inventory.filter((item) => item.name === name)[0];

    targetItem.stock = newStock;
    console.log(`[업데이트] ${name} 재고: ${newStock}개`);

    if (newStock < 5) {
      console.log(`[재고 부족 경고] ${name}: 재고가 5개 미만입니다!`);
    }
  }
  checkStock() {
    for (let item of this.inventory) {
      setTimeout(() => {
        if (item.stock < 5) {
          console.log(`[자동 경고] ${item.name}: 재고가 5개 미만입니다!`);
        }
      }, 1000);
    }
    setTimeout(() => {
      console.log('[재고 검사 종료]');
    }, 5000);
  }
}

const inventory = new InventoryManager();

// 아이템 등록
const item1 = new Item('고급 고양이 사료', '사료', 10);
inventory.addItem(item1);

// 재고 업데이트
inventory.updateStock('고급 고양이 사료', 4); // 5개 미만 → 경고 발생
inventory.updateStock('고급 고양이 사료', -1); // 음수 입력 → 오류 발생

// 재고 상태 검사 시작 (5초 후 종료)
inventory.checkStock();
