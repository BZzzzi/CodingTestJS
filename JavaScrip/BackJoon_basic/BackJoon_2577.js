let fs = require("fs");
let input = fs.readFileSync("./input.txt").toString().trim().split("\n");

let result = 1;
let arr = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

for (let i = 0; i < input.length; i++) {
  result *= input[i];
}

result = String(result);

for (let charNum of result) {
  arr[charNum]++;
}

for (let i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}
