let pikachu = { name: '피카츄', level: 5, xp: 20 };

// 여기에 함수를 작성하세요!
const levelUp = (pokemon) => {
  console.log(`${pokemon.name}이(가) 레벨업! 현재 레벨: ${pokemon.level}`);
  pokemon.level += 1;
  pokemon.xp = 0;
};

const gainXP = (pokemon) => {
  pokemon.xp += 30;

  if (pokemon.xp >= 50) {
    levelUp(pokemon);
  } else {
    console.log(
      `${pokemon.name}이(가) 경험치를 얻었다! 현재 경험치: ${pokemon.xp}`
    );
  }
};

gainXP(pikachu);
gainXP(pikachu);
