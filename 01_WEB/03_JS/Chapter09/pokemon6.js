let charmander = { name: '파이리', level: 14, evolution: '리자드' };
let pikachu = { name: '피카츄', level: 20, evolution: null };

// 여기에 함수를 작성하세요!
const levelUp = (target) => {
  target.level += 1;
  console.log(`${target.name}의 레벨이 ${target.level}이(가) 되었다!`);

  if (target.level >= 16 && target.evolution) {
    console.log(`${target.name}이(가) ${target.evolution}으로 진화했다!`);
  }
};

levelUp(charmander);
levelUp(charmander);
levelUp(pikachu);

// 파이리의 레벨이 15이(가) 되었다!
// 파이리의 레벨이 16이(가) 되었다!
// 파이리이(가) 리자드으로 진화했다!
// 피카츄의 레벨이 21이(가) 되었다!
