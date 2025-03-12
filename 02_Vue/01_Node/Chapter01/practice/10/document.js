export const calculateDiscount = (price, quantity) =>
  quantity * price * (quantity >= 5 ? 0.9 : 1);
