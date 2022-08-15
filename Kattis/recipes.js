  // Author: Kliver Daniel
  const readline = require('readline');

  const rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout
  });

  let n = 0;
  let nCase = '';
  let array = [];
  let recipe = 1;

  rl.on('line', (line) => {
      if (n == 0) {
          n = parseInt(line);
      } else if (n != 0 && nCase == 0) {
          nCase = line;
          array = [];
      } else {
          array.push(line);
      }

      if (array.length > 0 && array.length == parseInt(nCase.split(' ')[0])) {
        console.log(`Recipe # ${recipe++}`);
        let nCaseSplit = nCase.split(' ');
        let scalingFactor = parseInt(nCaseSplit[2]) / parseInt(nCaseSplit[1]);
        let mainIngredient = array.filter(x => x.endsWith('100.0')).toString().split(' ');
        let scaledWeight = parseFloat(mainIngredient[1]) * parseFloat(mainIngredient[2]) / 100;
        array.forEach(arr => {
          let arrLine = arr.split(' ');
          let per = parseFloat(arrLine[2]) / 100;
          let scaledWeightEach = scaledWeight;
          if (per != 100.0) {
            scaledWeightEach = scaledWeight * per * scalingFactor;
          }
          console.log(`${arrLine[0]} ${scaledWeightEach}`);
        });
        Array(40).fill().forEach(_ => process.stdout.write('-'));
        console.log();
        nCase = 0;
      }
  });
