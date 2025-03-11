let pokedex = [
  { name: '피카츄', type: '전기', level: 15 },
  { name: '꼬부기', type: '물', level: 10 },
  { name: '파이리', type: '불', level: 12 },
  { name: '이상해씨', type: '풀', level: 8 },
];

const findPokemon = (pokemon) => {
  const result = pokedex.filter(({ name }) => name === pokemon)[0];

  if (result) {
    const { name, type, level } = result;
    return `${name} - 타입: ${type}, 레벨: ${level}`;
  }

  return '도감에 없는 포켓몬입니다.';
};

console.log(findPokemon('파이리'));
console.log(findPokemon('뮤츠'));
