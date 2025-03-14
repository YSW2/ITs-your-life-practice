import fs, { promises } from 'node:fs';

const filePath = './logs/diet.txt';

const checkCalorie = async (name, calorie) => {
  let text;

  console.log(`${name} 회원님, 오늘도 건강한 한 끼 감사합니다!`);

  if (calorie < 500) {
    text = `${name}: ${calorie}kcal, 괜찮아요 아직 여유 있어요!\n`;
  } else {
    let warning = `${name} 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!`;

    text = `${name}: ${calorie}kcal, 조금 과했어요! 내일은 가볍게 가볼까요?\n`;
    text += `${warning}\n`;

    console.log(warning);
  }
  try {
    await promises.appendFile(filePath, text);
  } catch (error) {
    throw error;
  }
};

const app = async (name, calorie) => {
  try {
    if (!fs.existsSync(filePath)) {
      throw '식단 기록 파일이 어디로 갔죠?!';
    }
    console.log('식단 기록 중... (오늘도 건강한 한 끼!)');

    await new Promise((resolve) => setTimeout(resolve, 1000));
    await checkCalorie(name, calorie);
    console.log('식단 기록이 맛있게 저장되었습니다!');
  } catch (error) {
    console.log(error);
  }
};

app('이승기', 3500);
