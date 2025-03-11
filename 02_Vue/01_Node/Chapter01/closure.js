function outer() {
  let count = 1;
  return function inner() {
    count += 1;
    return count;
  };
}

closure = outer();
console.log(closure());
console.log(closure());
console.log(closure());
console.log(closure());
