const fs = require("fs");
const input = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

let result = 1;

for (let i = 1; i <= input[0]; i++) {
  if (i % 2 === 0) {
    result = (result * 2 + 1) % 10007;
  } else {
    result = (result * 2 - 1) % 10007;
  }
}

console.log(result);

/**
 * 링크: https://www.acmicpc.net/problem/11727
 * 1. 1 * 2 가로형
 * 2. 2 * 1 세로형
 * 3. 2 * 2 정사각형
 * 4. n의 방법의 수를 r이라고 한다면 n + 1은 [(n번째의 r) + 1칸], [1칸 + (n번째의 r)] 이렇게 r이 2번 적용된다.
 * 5. 때문에 result * 2를 했고, 1칸짜리로만 채워지는 경우가 중복 계산 되기 때문에 - 1
 * 6. 하지만 짝수는 2칸짜리로만 채워지는 경우 + 2가 되기 때문에 - 1을 하면 + 1
 * 7. 결론적으로 홀수번째는 - 1, 짝수번째는 + 1 이 된다.
 * 8. 정석인 방식 - 점화식 참고: dp[n] = dp[n - 1] + 2 * dp[n - 2], (dp[1] = 1, dp[2] = 3)
 */
