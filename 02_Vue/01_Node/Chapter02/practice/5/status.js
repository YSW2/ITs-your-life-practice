export const orderStatus = { 삼겹살: '주문 대기', 갈비: '주문 대기' };

export const updateStatus = async (menu, status) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      orderStatus[menu] = status;
      resolve(`🔄 ${menu} 상태가 '${status}'로 변경되었습니다.`);
    }, 1000);
  });
};
