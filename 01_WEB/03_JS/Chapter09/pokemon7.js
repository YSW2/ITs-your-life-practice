let bulbasaur = { name: '이상해씨', level: 5, skills: ['몸통박치기'] };
let newSkills = {
  7: '덩굴채찍',
  10: '씨뿌리기',
  16: '솔라빔',
};

// 여기에 함수를 작성하세요!
const levelUp = (bulbasaur) => {
  bulbasaur.level += 1;
  console.log(`${bulbasaur.name}의 레벨이 ${bulbasaur.level}이(가) 되었다!`);

  if (bulbasaur.level in newSkills) {
    bulbasaur.skills.push(newSkills[bulbasaur.level]);
    console.log(
      `${bulbasaur.name}가 새로운 기술 ${
        newSkills[bulbasaur.level]
      }을(를) 배웠다!`
    );
  }
};

levelUp(bulbasaur);
levelUp(bulbasaur);
levelUp(bulbasaur);
