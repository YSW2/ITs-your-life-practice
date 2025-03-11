function add(a, b) {
  return a + b;
}

function sum(n) {
  let s = 0;
  for (let i = 0; i <= n; i++) {
    s = add(s, i);
  }
  return s;
}

console.log(sum(100));
