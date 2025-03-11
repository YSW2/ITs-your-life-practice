let pikachu = { name: '피카츄', hp: 100, attack: 20 };
let charmander = { name: '파이리', hp: 80, attack: 15 };

// 여기에 함수를 작성하세요!
const attackPokemon = (pokemon1, pokemon2) => {
  pokemon2.hp -= pokemon1.attack;
  console.log(
    `${pokemon1.name}이(가) ${pokemon2.name}를 공격했다! 남은 체력: ${pokemon2.hp}`
  );
  if (pokemon2.hp <= 0) {
    console.log(`${pokemon2.name}이(가) 쓰러졌다!`);
  }
};

attackPokemon(pikachu, charmander);
attackPokemon(charmander, pikachu);
attackPokemon(pikachu, charmander);
attackPokemon(pikachu, charmander);
attackPokemon(pikachu, charmander);
