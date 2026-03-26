const fs = require("fs");
const rawInput = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

const processedInput = rawInput.slice(1);
const result = [];
let resultNum = 0;
let idx = 0;

for (i of processedInput) {
  if (i > 0) {
    result[idx] = i;
    idx++;
  } else {
    result.pop();
    idx--;
  }
}

if (result.length === 0) {
  console.log(0);
} else {
  for (let i = 0; i < result.length; i++) {
    resultNum += result[i];
  }
  console.log(resultNum);
}

/**
 * 링크: https://www.acmicpc.net/problem/10773
 * 1. 0이 아니면 result 배열에 담는다.
 * 2. 0이면 result 배열의 마지막 수를 pop으로 지운다.
 */
