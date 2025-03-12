import { processOrder } from './oredrProcessor.js';

const orders = [
  ['삼겹살', 3],
  ['갈비', 2],
  ['오겹살', 5],
];

const processAllOrders = async () => {
  for (let order of orders) {
    console.log(await processOrder(order));
  }
};

processAllOrders();
