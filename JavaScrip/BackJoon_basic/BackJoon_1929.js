const fs = require("fs");
const input = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

let M = input[0];
let N = input[1];
const isPrime = Array(N + 1).fill(true);
isPrime[0] = false;
isPrime[1] = false;

for (let i = 2; i * i <= N; i++) {
  if (isPrime[i]) {
    for (let j = i * i; j <= N; j += i) {
      isPrime[j] = false;
    }
  }
}

for (let i = M; i <= N; i++) {
  if (isPrime[i]) console.log(i);
}

/**
 * 링크: https://www.acmicpc.net/problem/1929
 * 1. 소수를 찾아서 배열에 추가하는 방식으로 구현했으나 시간 초과가 났다.
 * 2. 찾아보니 에라토스테네스의 체 알고리즘을 사용해야 한다.
 * 3. 2부터 시작해서 소수가 아닌 숫자를 제외해 가면서 풀어야 한다.
 */
