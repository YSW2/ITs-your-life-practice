const findRandomPokemon = () => {
  let pokemons = ['피카츄', '파이리', '꼬부기', '이상해씨', '뮤츠', '리자몽'];
  let index = Math.floor(Math.random() * (pokemons.length - 1));

  return '야생의 ' + pokemons[index] + '가 나타났다!';
};

console.log(findRandomPokemon());
console.log(findRandomPokemon());
console.log(findRandomPokemon());
