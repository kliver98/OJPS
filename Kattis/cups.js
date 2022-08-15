// Author: Kliver Daniel
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let n = 0;
let array = []

rl.on('line', (line) => {
  if (n == 0) {
    n = parseInt(line);
  } else {
    array.push(line);
  }
  
  if (array.length == n) {
    array = array.sort((a, b) => {
      let first = a.split(' ');
      let second = b.split(' ');
      if (isNaN(parseInt(first[0]))) {
          first = first[1];
      } else {
          first = first[0] / 2;
      }
      
      if (isNaN(parseInt(second[0]))) {
          second = second[1];
      } else {
          second = second[0] / 2;
      }
      
      return first - second;
      });

      array.forEach(arr => {
          let line = arr.split(' ');
          line = isNaN(parseInt(line[0])) ? line[0] : line[1];
          console.log(line);
      });
      array = [];   
  }
});
