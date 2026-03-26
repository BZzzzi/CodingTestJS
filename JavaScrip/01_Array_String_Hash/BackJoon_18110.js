const fs = require("fs");
let input = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number)
  .slice(1);

if (input.length === 0) {
  console.log(0);
} else {
  input.sort((a, b) => a - b);
  const n = Math.round(input.length * 0.15);
  input = input.slice(n, input.length - n);

  let result = 0;
  for (i of input) {
    result += i;
  }

  result = Math.round(result / input.length);
  console.log(result);
}

/**
 * 링크: https://www.acmicpc.net/problem/18110
 * 1. 배열이 없을 때의 전처리 해줘야 한다.
 * 2. 절사평균 15% 제외를 shift, pop으로 하면 시간 초과가 난다.
 * 3. slice로 한 번만 배열 정리해주는 방법으로 하면 쉽게 풀리는 문제
 */
