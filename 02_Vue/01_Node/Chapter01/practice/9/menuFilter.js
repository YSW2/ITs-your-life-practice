export const filterMenuByPrice = async (menu, maxPrice) => {
  return new Promise((resolve, _) => {
    setTimeout(() => {
      let result = menu.filter(({ menu, price }) => price <= maxPrice);
      resolve(result);
    }, 1000);
  });
};
