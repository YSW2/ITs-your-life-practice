import { menu } from './menu.js';
import { filterMenuByPrice } from './menuFilter.js';

const showAffordableMenu = async () => {
  const result = await filterMenuByPrice(menu, 18000);

  console.log('✅ 선택 가능한 메뉴:');
  for (let { menu, price } of result) {
    console.log(`${menu}: ${price}원`);
  }
};

showAffordableMenu();
