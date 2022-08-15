// Author: Kliver Daniel
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', (line) => {
  let total = 0;
    let nums = line.split(';');
    nums.forEach(ns => {
      let eachs = ns.split('-');
      if (eachs.length == 1) {
        total++;
      } else {
        total += (eachs[1]-eachs[0]+1);
      }
    });
  console.log(total);
});
