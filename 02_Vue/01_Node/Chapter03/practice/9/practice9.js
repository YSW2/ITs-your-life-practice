import fs, { promises } from 'node:fs';

const filePath = './logs/routine.txt';
const memberFilePath = './logs/memberRoutine.txt';

const upperRoutineList = [
  '벤치프레스 3세트',
  '어깨프레스 3세트',
  '팔굽혀펴기 50개',
];

const lowerRoutineList = ['스쿼트 5세트', '런지 3세트', '레그프레스 4세트'];

const getRandom = (x, y) => Math.floor((y - x) * Math.random() + x);

const recommendExercise = async (name, routine) => {
  let exercise;
  let index;

  switch (routine) {
    case '상체':
      index = getRandom(0, upperRoutineList.length);
      exercise = upperRoutineList[index];
      break;

    case '하체':
      index = getRandom(0, lowerRoutineList.length);
      exercise = lowerRoutineList[index];
      break;
  }

  console.log(
    `${name} 회원님, 오늘의 상체 추천 루틴은 '${exercise}' 입니다! 화이팅!`
  );

  try {
    await promises.appendFile(filePath, `${name} (${routine}): ${exercise}\n`);
  } catch (error) {
    throw error;
  }
};

const getRoutineList = async () => {
  const result = await promises.readFile(memberFilePath, 'utf-8');
  const data = result.split('\n').map((line) => line.trim().split(': '));
  return data;
};

const checkDup = async (name) => {
  const checkList = (await promises.readFile(filePath, 'utf-8'))
    .split('\n')
    .map((check) => check.split(' ')[0]);

  return checkList.includes(name);
};

const app = async () => {
  try {
    if (!fs.existsSync(filePath)) {
      throw '운동 루틴 기록 파일이 없습니다!';
    }

    if (!fs.existsSync(memberFilePath)) {
      throw '회원 루틴 파일이 없습니다!';
    }

    const routineList = await getRoutineList();

    for (let [name, routine] of routineList) {
      console.log(`운동 루틴 추천 중... (${name})`);

      if (await checkDup(name)) {
        throw `${name} 회원님은 이미 추천을 받으셨습니다!`;
      }
      await new Promise((resolve) => setTimeout(resolve, 1000));
      await recommendExercise(name, routine);

      console.log(`${name} 회원님의 추천 루틴이 기록되었습니다!`);
    }
  } catch (error) {
    console.log(error);
  }
};

app();
