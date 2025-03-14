import fs, { promises } from 'node:fs';

const filePath = './logs/checkin.txt';

const checkIn = async (name) => {
  const time = new Date().toLocaleString();
  const checkText = `${name}: 출석 완료 (${time})\n`;

  try {
    await promises.appendFile(filePath, checkText);
    console.log(checkText);
    console.log('출석 기록이 파일에 저장되었습니다!');
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

const app = async (name) => {
  try {
    if (!fs.existsSync(filePath)) {
      throw '출석 기록 파일이 없습니다.';
    }

    if (await checkDup(name)) {
      throw `${name} 회원님은 이미 출석하셨습니다!`;
    }

    console.log('출석 중...');

    await new Promise((resolve) => setTimeout(resolve, 1000));
    await checkIn(name);
  } catch (error) {
    console.log(error);
  }
};

app('이승기');
