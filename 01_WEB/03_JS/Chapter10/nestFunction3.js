function outer() {
  let outValue = 5678;

  function inner() {
    let inValue = 1234;

    console.log('outValue = ' + outValue);
  }

  inner();
  console.log('inValue = ' + inValue);
}

outer();
