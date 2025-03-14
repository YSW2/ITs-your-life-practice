export const grillMeat = async (menu) => {
  const promise = new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(`🔥 ${menu}가 다 구워졌습니다!`);
    }, 2000);
  });
  return promise;
};
