let squirtle = { name: '꼬부기', hp: 50, attack: 10, type: '물' };
let bulbasaur = { name: '이상해씨', hp: 50, attack: 8, type: '풀' };

// 여기에 함수를 작성하세요!
const compareType = (type1, type2, damage) => {
  if (
    (type1 === '물' && type2 === '불') ||
    (type1 === '불' && type2 === '풀') ||
    (type1 === '풀' && type2 === '물')
  ) {
    damage *= 2;
  }
  if (
    (type2 === '물' && type1 === '불') ||
    (type2 === '불' && type1 === '풀') ||
    (type2 === '풀' && type1 === '물')
  ) {
    damage /= 2;
  }

  return damage;
};

const battle = (pokemon1, pokemon2) => {
  let damage = compareType(pokemon1.type, pokemon2.type, pokemon1.attack);

  pokemon2.hp -= damage;
  console.log(
    `${pokemon1.name}이(가) ${pokemon2.name}을(를) 공격했다! (피해량: ${damage})`
  );
  console.log(`${pokemon2.name}의 남은 체력: ${pokemon2.hp}`);
};

battle(squirtle, bulbasaur);
battle(bulbasaur, squirtle);

// 꼬부기이(가) 이상해씨을(를) 공격했다! (피해량: 5)
// 이상해씨의 남은 체력: 45
// 이상해씨가 꼬부기를 공격했다! (피해량: 16)
// 꼬부기의 남은 체력: 34
