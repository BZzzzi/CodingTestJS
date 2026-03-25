const fs = require("fs");
const input = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

const N = input.slice(1, input[0] + 1).sort((a, b) => a - b);
const M = input.slice(input[0] + 2);
const result = [];
let resultIdx = 0;

let low = 0;
let high = 0;
let left = 0;
let right = N.length;
function binarySearch(num) {
  left = 0;
  right = N.length;

  while (left < right) {
    mid = Math.floor((left + right) / 2);
    if (N[mid] > num) right = mid;
    else left = mid + 1;
  }
  high = left;

  left = 0;
  right = N.length;

  while (left < right) {
    mid = Math.floor((left + right) / 2);
    if (N[mid] >= num) right = mid;
    else left = mid + 1;
  }
  low = left;
}

for (i of M) {
  binarySearch(i);
  console;
  result[resultIdx] = high - low;
  resultIdx++;
}

console.log(result.join(" "));

/**
 * 링크: https://www.acmicpc.net/problem/10816
 * 1. 이진 탐색으로 mid 값이 정수 M보다 큰지, 작은지 비교를 반복하여 범위를 줄여간다.
 * 2. M을 처음 찾은 지점과 M보다 커진 지점을 찾아서 빼주면 M이 N 카드에 몇 개 있는지 알 수 있다.
 */
