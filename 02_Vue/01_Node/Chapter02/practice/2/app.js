import { addOrder, orderList } from './orderManager.js';

addOrder('삼겹살', 3);
addOrder('목살', 2);

if (orderList.length) {
  console.log('✅ 현재 주문 내역:');
  for (let { menu, quantity } of orderList) {
    console.log(`${menu}: ${quantity}인분`);
  }
} else {
  console.log('❌ 주문 내역이 없습니다.');
}
