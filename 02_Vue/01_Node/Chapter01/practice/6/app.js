import { orders } from './orderList.js';
import {
  calculateTotal as calc,
  isTopMenu as isTop,
} from './orderProcessor.js';

const result = calc(orders);
console.log(`✅ 총 주문 수량: ${JSON.stringify(result)}`);

let check = isTop(result, '삼겹살');
console.log(`🥩 삼겹살이 가장 인기 메뉴인가요? ${check ? '네!' : '아니오!'}`);

check = isTop(result, '목살');
console.log(`🥩 목살이 가장 인기 메뉴인가요? ${check ? '네!' : '아니오!'}`);
