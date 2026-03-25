const fs = require("fs");
const input = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

const N = input[0];
const K = input[1];

const arr = [];
let arrIdx = 0;

const resultArr = [];
let resultIdx = 0;

let nextCount = 0;

for (let i = 1; i <= N; i++) {
  arr[i - 1] = { num: i, check: false };
}

while (1) {
  while (1) {
    if (!arr[arrIdx].check) {
      nextCount++;
    }
    if (nextCount === K) {
      nextCount = 0;
      break;
    }
    arrIdx = (arrIdx + 1) % N;
  }
  arr[arrIdx].check = true;
  resultArr[resultIdx] = arr[arrIdx].num;
  resultIdx++;

  if (resultArr.length === N) {
    console.log("<" + resultArr.join(", ") + ">");
    return;
  }
}

/**
 * 링크: https://www.acmicpc.net/problem/11866
 * 1. K번째 순서를 찾을 때 이미 제거된 번호인지 확인하는 로직을 만들면 풀리는 문제
 * 2. 제거 되지 않은 번호면 카운트 하여, K번째 순서면 제거한다.
 * 3. 이를 반복하여 출력 배열의 길이가 N개 되면 출력 후 종료한다.
 */
