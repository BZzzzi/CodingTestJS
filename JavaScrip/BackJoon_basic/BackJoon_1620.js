const fs = require("fs");
const input = fs.readFileSync("./input.txt").toString().trim().split(/\s+/);

const n = Number(input[0]);
const m = Number(input[1]);

const strMap = new Map();
const numMap = new Map();

for (let i = 1; i <= n; i++) {
  numMap.set(i, input[i + 1]);
  strMap.set(input[i + 1], i);
}

for (let j = 2; j <= m + 1; j++) {
  if (!isNaN(Number(input[n + j]))) {
    console.log(numMap.get(Number(input[n + j])));
  } else {
    console.log(strMap.get(input[n + j]));
  }
}

/**
 * 링크: https://www.acmicpc.net/problem/1620
 * - n과 m이 10만 단위이므로, 배열 2개로 선형 탐색하는 것은 시간 초과로 불가능
 * - value는 중복이 가능하기 때문에 숫자와 문자 모두 key로 둔다.
 * - 2개의 Map 자료 구조를 이용하여 문제 해결
 */
