import fs, { promises } from 'node:fs';

const filePath = './logs/reservation.txt';

const reservation = async (name, exercise) => {
  try {
    await promises.appendFile(filePath, `${name}: ${exercise}\n`);
    console.log(`${name} 회원님의 ${exercise} 예약이 완료되었습니다!`);
  } catch (error) {
    throw error;
  }
};

const checkDup = async (name) => {
  const checkList = (await promises.readFile(filePath, 'utf-8'))
    .split('\n')
    .map((check) => check.split(':')[0]);

  return checkList.includes(name);
};

const app = async (name, exercise) => {
  try {
    if (!fs.existsSync(filePath)) {
      throw '예약 기록 파일이 없습니다.';
    }

    if (await checkDup(name)) {
      throw `${name} 회원님은 이미 예약되어 있습니다.`;
    }

    console.log('예약 처리 중...');

    await new Promise((resolve) => setTimeout(resolve, 2000));
    await reservation(name, exercise);
    console.log('예약 기록이 파일에 저장되었습니다.');
  } catch (error) {
    console.log(error);
  }
};

app('이승기', '스피닝');
