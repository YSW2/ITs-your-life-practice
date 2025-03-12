import { orderList } from './order.js';

const orderPork = orderList['삼겹살'];

if (orderPork) {
  console.log(`삼겹살 주문 수량:  ${orderPork}`);
} else {
  console.log('❌ 삼겹살 주문 내역이 없습니다.');
}
