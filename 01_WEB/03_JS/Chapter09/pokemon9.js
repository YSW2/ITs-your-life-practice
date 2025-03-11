// 여기에 함수를 작성하세요!
const pokedex = [];

const addPokemon = (name, type, level) => {
  console.log(`${name}이(가) 도감에 등록되었습니다!`);
  pokedex.push({ name, type, level });
};

addPokemon('뮤츠', '에스퍼', 70);
addPokemon('망나뇽', '드래곤', 55);

console.log(...pokedex);
