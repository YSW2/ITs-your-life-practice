const getPokemonTypeInfo = (type) => {
  switch (type) {
    case '불':
      return '🔥 불 타입 포켓몬은 강한 공격력을 가지고 있어!';
    case '물':
      return '💧 물 타입 포켓몬은 유연한 전투 스타일을 가지고 있어!';
    case '풀':
      return '🌿 풀 타입 포켓몬은 회복 능력이 뛰어나!';
    default:
      return '🤔 알 수 없는 타입이네!';
  }
};

console.log(getPokemonTypeInfo('불'));
console.log(getPokemonTypeInfo('물'));
console.log(getPokemonTypeInfo('전기'));
