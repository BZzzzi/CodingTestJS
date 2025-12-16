const fs = require("fs");
let N = Number(fs.readFileSync("./input.txt").toString());

const dp = Array(N + 1).fill(Infinity);
dp[0] = 0;

for (let i = 1; i <= N; i++) {
  for (let j = 1; j * j <= i; j++) {
    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
  }
}

console.log(dp[N]);
/**
 * 링크: https://www.acmicpc.net/problem/17626
 * 1. 정수 N을 만드는 최소 개수는 N에서 제곱수 하나 빼고, 그 나머지 수를 만든 제곱수들의 최소 개수를 알면 된다.
 * 2. N에서 제곱수 하나를 빼고 -> 제곱수 1개 사용
 * 3. N - 제곱수를 만드는 최소 개수  -> dp 배열에 1부터 시작해서 개수를 저장해둔 걸 가져온다.
 * 4. 2번, 3번에 의해 점화식은 dp[N] = min(dp[N], dp[N - k²] + 1)
 */
