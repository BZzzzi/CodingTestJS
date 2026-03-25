const fs = require("fs");
const input = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

const arrN = input.slice(1, input[0] + 1);
const arrM = input.slice(input[0] + 2, input.length);

const map = new Map();
for (num of arrN) {
  map.set(num, (map.get(num) || 0) + 1);
}

const result = [];
let idx = 0;

for (num of arrM) {
  result[idx] = map.get(num) || 0;
  idx++;
}

console.log(result.join(" "));

/**
 * 링크: https://www.acmicpc.net/problem/10816
 * 1. 정수 M이 N 카드들 중에 몇 개 있는지를 찾는 문제이다.
 * 2. N 중 같은 숫자들을 먼저 묶어준다.
 *    10 → 3개 / -10 → 2개 ...
 * 3. M을 만나는 로직을 미리 세어둔 숫자를 주면 출력하면 된다.
 *    M이 10 → 3 출력 / M이 -10 → 2 출력
 */
