export const calculateTotal = (orderList) => {
  const result = {};

  for (let { menu, quantity } of orderList) {
    let quantityNumber = Number(quantity[0]);

    result[menu] = (result[menu] ?? 0) + quantityNumber;
  }
  return result;
};

export const isTopMenu = (orderList, menu) =>
  orderList[menu] == Math.max(...Object.values(orderList));
