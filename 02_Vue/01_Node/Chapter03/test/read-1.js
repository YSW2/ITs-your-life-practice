const fs = require('fs');

const file = fs.readFileSync(`${__filename}/../example.txt`).toString();
console.log(file);
