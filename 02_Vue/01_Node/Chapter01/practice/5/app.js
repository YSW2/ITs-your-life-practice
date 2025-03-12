import { orderStatus, updateStatus } from './status.js';

const trackStatus = async () => {
  console.log(await updateStatus('삼겹살', '굽는 중'));
  console.log(await updateStatus('삼겹살', '완료'));
  console.log(await updateStatus('갈비', '굽는 중'));
  console.log(await updateStatus('갈비', '완료'));
  console.log(
    `📋 최종 주문 상태: { 삼겹살: ${orderStatus['삼겹살']}, 갈비: ${orderStatus['갈비']} }`
  );
};

trackStatus();
