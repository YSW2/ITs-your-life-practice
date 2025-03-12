import { grillMeat } from './grill.js';

const startGrilling = async () => {
  const result = await grillMeat('갈치');
  console.log(result);
  console.log('🍽️ 식사 시작!');
};

startGrilling();
