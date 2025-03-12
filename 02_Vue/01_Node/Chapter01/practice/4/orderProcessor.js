export const processOrder = async (order, quantity) => {
  return new Promise((resolve, _) => {
    setTimeout(() => {
      resolve(`${order} ${quantity}인분 주문 처리 완료!`);
    }, 1000);
  });
};
