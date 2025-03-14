import fs, { promises } from 'node:fs';
import * as readline from 'node:readline/promises';
import { stdin as input, stdout as output } from 'node:process';

const benchPath = './logs/bench.txt';
const squatPath = './logs/squat.txt';
const deadliftPath = './logs/deadlift.txt';

const getRecord = (target, list) => {
  const result = list.filter(([name, _]) => name === target).flat();
  if (result) {
    return Number(result[1]);
  }
  return false;
};

const app = async () => {
  try {
    if (
      !fs.existsSync(benchPath) ||
      !fs.existsSync(squatPath) ||
      !fs.existsSync(deadliftPath)
    ) {
      throw '운동 기록 파일이 없습니다!';
    }

    console.log('이름을 입력하세요. (이름 사이에 공백을 두고 입력하세요)');

    const nameList = [];
    const rl = readline.createInterface({ input, output });

    const answer = await rl.question('');
    rl.close();

    answer.split(' ').forEach((name) => nameList.push(name));

    const benchRecordList = await promises
      .readFile(benchPath, 'utf-8')
      .then((data) => data.split('\n').map((data) => data.trim().split(': ')));

    const squatRecordList = await promises
      .readFile(squatPath, 'utf-8')
      .then((data) => data.split('\n').map((data) => data.trim().split(': ')));

    const deadliftRecordList = await promises
      .readFile(deadliftPath, 'utf-8')
      .then((data) => data.split('\n').map((data) => data.trim().split(': ')));

    for (let name of nameList) {
      const benchRecord = getRecord(name, benchRecordList);
      const squatRecord = getRecord(name, squatRecordList);
      const deadliftRecord = getRecord(name, deadliftRecordList);

      if (!(benchRecord && squatRecord && deadliftRecord)) {
        console.log(`${name} 회원님의 기록이 없습니다!`);
      } else {
        const totalRecord = benchRecord + squatRecord + deadliftRecord;

        if (totalRecord >= 500) {
          console.log(`${name} 회원님! 3대 500 돌파! 강력한 힘의 소유자!`);
        } else if (totalRecord >= 200) {
          console.log(`${name} 회원님, 3대 200은 넘으셨네요. 꾸준히 파이팅!`);
        } else {
          console.log(`${name} 회원님... 한세트만 더 하시죠^^`);
        }
      }
    }
  } catch (error) {
    console.log(error);
  }
};

app();
