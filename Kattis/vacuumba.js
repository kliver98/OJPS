// Author: Kliver Daniel
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let n = 0;
let nCase = 0;
let array = []

rl.on('line', (line) => {
    if (n == 0) {
        n = parseInt(line);
    } else if (n != 0 && nCase == 0) {
        nCase = parseInt(line);
        array = [];
    } else {
        array.push(line);
    }

    if (array.length > 0 && array.length == nCase) {
        let xAxisCount = 0;
        let yAxisCount = 0;
        let ang = 0;
        array.forEach(arr => {
            let splitted = arr.split(' ');
            let a, b = [0, 0];
            [a, b] = [parseFloat(splitted[0]), parseFloat(splitted[1])];
            ang += a;
            xAxisCount += (Math.sin(-ang * Math.PI/180) * b);
            yAxisCount += (Math.cos(-ang * Math.PI/180) * b);
        });
        let round = (number) => Number((number).toFixed(7));
        console.log(`${round(xAxisCount)} ${round(yAxisCount)}`);
        nCase = 0;
    }
});
