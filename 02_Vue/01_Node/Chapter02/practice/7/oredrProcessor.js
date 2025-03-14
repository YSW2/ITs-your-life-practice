export const processOrder = (order) => {
  const [menu, quantity] = order;

  return new Promise((resolve, _) => {
    setTimeout(() => {
      if (quantity >= 3) {
        resolve(`✅ ${menu} ${quantity}인분 주문 완료!`);
      } else {
        resolve(`❌ ${menu} ${quantity}인분은 주문 최소 수량 미달입니다.`);
      }
    }, 1000);
  });
};
