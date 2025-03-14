import { calculateDiscount as discount } from './document.js';

const result = discount(15000, 5);
console.log(`✅ 최종 결제 금액: ${result}원`);
