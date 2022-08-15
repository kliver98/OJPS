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
        array.forEach(arr => {
            let ns = arr.split(' ');
            let a, b, c = [0, 0, 0];
            [a, b, c] = [parseInt(ns[0]), parseInt(ns[1]), parseInt(ns[2])]; 
            if (a + b == c) {
                console.log('Possible');
            }else if (a - b == c || b - a == c) {
                console.log('Possible');
            }else if (a * b == c) {
                console.log('Possible');
            }else if (a / b == c || b / a == c) {
                console.log('Possible');
            } else {
                console.log('Impossible');
            }
        });
    }
});
