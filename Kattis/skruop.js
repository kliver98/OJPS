// Author: Kliver Daniel
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let total = 0;
let array = []

rl.on('line', (line) => {
  if (total == 0) {
    total = parseInt(line);
  } else {
    array.push(line);
  }

  if (array.length == total) {
    total = 7;
    array.forEach(arr => {
      if (arr == 'Skru op!' && total < 10) {
        total++;
      } else if (arr == 'Skru ned!' && total > 0) {
        total--;
      }
    });
    console.log(total);
  }
});
