// Author: Kliver Daniel
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', (line) => {
    let total = line.length;
    let spaces = 0;
    let lowerChars = 0;
    let upperChars = 0;
    let symbols = 0;
    line.split('').forEach(character => {
        let n = character.charCodeAt(0);
        if (n == 95) {
            spaces++;
        } else if (n > 96 && n < 123) {
            lowerChars++;
        } else if (n > 64 && n < 91) {
            upperChars++;
        } else {
            symbols++;
        }
    });
    console.log(spaces/total);
    console.log(lowerChars/total);
    console.log(upperChars/total);
    console.log(symbols/total);
});

