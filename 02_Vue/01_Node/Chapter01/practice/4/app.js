import { processOrder } from './orderProcessor.js';

const orderList = [
  ['삼겹살', '2'],
  ['목살', '3'],
  ['갈비', '1'],
];

const processOrders = async () => {
  for (let [order, quantity] of orderList) {
    console.log(await processOrder(order, quantity));
  }
  console.log('🍽️ 모든 주문 처리 완료! 식사 시작!');
};

processOrders();
