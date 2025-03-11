function sum(n) {
  function add(a, b) {
    return a + b;
  }
  let s = 0;
  for (let i = 0; i <= n; i++) {
    s = add(s, i);
  }
  return s;
}

// sum 함수 외부에서는 add 함수를 찾을 수 없다.
console.log(add(100));
