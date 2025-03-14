const runStretching = async () => {
  return new Promise((resolve, _) => {
    setTimeout(() => {
      resolve('스트레칭 완료');
    }, 1000);
  });
};
const runTreadmill = async () => {
  return new Promise((resolve, _) => {
    setTimeout(() => {
      resolve('런닝머신 완료');
    }, 500);
  });
};
const runProtein = async () => {
  return new Promise((resolve, _) => {
    setTimeout(() => {
      resolve('단백질 보충 완료');
    }, 0);
  });
};

console.log('운동 기록 처리 시작');
console.log(await runStretching());
console.log(await runTreadmill());
console.log(await runProtein());
console.log('운동 기록 처리 종료');
