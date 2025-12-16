const fs = require("fs");
const rawInput = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

const N = rawInput[1];
const processedInput = rawInput.slice(2);

let left = 1;
let right = Math.max(...processedInput);
let answer = 0;

while (left <= right) {
  const mid = Math.floor((left + right) / 2);

  let count = 0;
  for (i of processedInput) {
    count += Math.floor(i / mid);
    if (count >= N) break;
  }

  if (count >= N) {
    answer = mid;
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}

console.log(answer);

/**
 * 링크: https://www.acmicpc.net/problem/1654
 * 1. 랜선 중 최대 길이가 1cm 라면, 탐색 시작점인 left를 0으로 두면 mid가 0이 되버린다.
 * 2. 0cm는 탐색 범위가 아니기 때문에 left를 1로 둔다.
 * 3. 최대 길이가 K 렌선 보다 길 순 없으르모 right를 K 랜선 중에서 제일 긴 값으로 둔다.
 * 4. N개를 만들 수 있는 랜선의 최대 길이를 구해야 한다.
 *
 * - 이분 탐색으로 해결하면 된다.
 *
 * 1. count가 K 보다 작은 경우 → mid 보다 길이가 짦아져야 한다.
 *  ⇒ 정답 길이의 범위는 [left ~ (mid - 1)]이 된다.
 *  ⇒ 그래서 right = mid - 1
 *
 * 2. count가 K 보다 큰 경우 → mid 보다 길이가 길어져야 한다.
 *  ⇒ 정답 길이의 범위는 [(mid + 1) ~ right]이 된다.
 *  ⇒ 그래서 left = mid + 1
 *
 * 3. count가 K와 같은 경우 → 같은 count 내에서 가장 긴 길이를 찾아야 한다.
 *  ⇒ right와 만날 때 까지 left를 + 1 해주면 된다.
 *  ⇒ 그러면 mid 값이 점점 늘어날 것이고 while은 멈추게 된다.
 *
 * 4. 만약 같은 count 내에서 가장 짧은 길이를 찾아야 한다면?
 *  ⇒ 반대로 left와 만날 때 까지 right를 - 1 해주면 된다.
 *  ⇒ 그러면 mid 값이 점점 줄어들 것이고 while은 멈추게 된다.
 */
