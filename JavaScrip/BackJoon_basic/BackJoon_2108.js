const fs = require("fs");
const rawInput = fs.readFileSync("./input.txt").toString().trim().split(`\n`);
const processedInput = rawInput
  .slice(1)
  .map(Number)
  .sort((a, b) => a - b);

let mean = 0;

let median = 0;
let medianNum = Math.floor(processedInput.length / 2);

let maxCount = 0;
let modeArray = [];
let modeResult = {};
let mode = {};

let range = processedInput[processedInput.length - 1] - processedInput[0];

for (let i = 0; i < processedInput.length; i++) {
  mean += processedInput[i];
  if (i === medianNum) {
    median += processedInput[i];
  }
}

for (let i = -4000; i < 4001; i++) {
  modeArray[i] = 0;
}

for (let i = 0; i < processedInput.length; i++) {
  modeArray[processedInput[i]]++;
}

for (let i = -4000; i < 4001; i++) {
  if (modeArray[i] > 0) {
    if (modeArray[i] > maxCount) {
      maxCount = modeArray[i];
    }
    modeResult[i] = modeArray[i];
  }
}

for (let i in modeResult) {
  if (modeResult[i] === maxCount) {
    mode[i] = modeResult[i];
  }
}
const sortKeys = Object.keys(mode).sort((a, b) => Number(a) - Number(b));
mean = Math.round(mean / processedInput.length);

console.log(mean === 0 ? 0 : mean);
console.log(median === 0 ? 0 : median);
console.log(sortKeys[1] ?? sortKeys[0]);
console.log(range === 0 ? 0 : range);

/**
 * 링크: https://www.acmicpc.net/problem/2108
 * 1. 최빈값의 음수 인덱스 때문에 객체로 처리한 점은 보완이 필요하다.
 * 2. -4000 ~ 4001 보단 0 ~ 8001로 바꿔서 처리해도 좋을 것 같다.
 */
