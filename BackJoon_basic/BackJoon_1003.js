const fs = require("fs");
const input = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

const T = input[0];
let zeroCount = [];
let oneCount = [];

for (let i = 1; i <= T; i++) {
  if (input[i] === 0) {
    oneCount.push(0);
    zeroCount.push(1);
  } else if (input[i] === 1) {
    oneCount.push(1);
    zeroCount.push(0);
  } else {
    zeroCount = [1, 0];
    oneCount = [0, 1];
    for (let j = 2; j <= input[i]; j++) {
      zeroCount[j] = zeroCount[j - 1] + zeroCount[j - 2];
      oneCount[j] = oneCount[j - 1] + oneCount[j - 2];
    }
  }
  console.log(
    zeroCount[zeroCount.length - 1] + " " + oneCount[oneCount.length - 1]
  );
}

/**
 * 링크: https://www.acmicpc.net/problem/1003
 * - 피보나치 n과 n - 1의 결과를 출력하면 시간 초과가 난다.
 * - 피보나치 식을 0을 세는 카운트와 1을 세는 카운트에 적용하면 된다.
 */
