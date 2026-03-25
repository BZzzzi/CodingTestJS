const fs = require("fs");
const input = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

const n = input[0];
let arr = [];

for (let i = 1; i <= n; i++) {
  if (input[i] === 0 && arr.length === 0) {
    console.log(0);
  } else if (input[i] === 0) {
    console.log(Math.min(...arr));
    arr.pop(input[i]);
  } else {
    arr.push(input[i]);
    arr.sort((a, b) => b - a);
  }
}

/**
 * 링크: https://www.acmicpc.net/problem/1927
 */
