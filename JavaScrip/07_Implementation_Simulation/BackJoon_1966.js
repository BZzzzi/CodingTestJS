const fs = require("fs");
const input = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

const T = input[0];
let idx = 1;

for (let i = 0; i < T; i++) {
  let n = input[idx++];
  let m = input[idx++];
  let arr = [];
  let count = 0;

  for (let j = 0; j < n; j++) {
    arr[j] = { priority: input[idx++], idx: j };
  }

  while (arr.length > 0) {
    const front = arr[0];
    const maxPriority = Math.max(...arr.map((x) => x.priority));
    if (front.priority < maxPriority) {
      arr.push(arr.shift());
    } else {
      arr.shift();
      count++;
      if (front.idx === m) {
        console.log(count);
        break;
      }
    }
  }
}

/**
 * 링크: https://www.acmicpc.net/problem/1966
 * 1. 우선순위와 인덱스를 함께 저장하는 방식과 우선 순위 요소를 체크할 위치를 떠올리는 것에 시간을 많이 썼다.
 * 2. 우선순위 max 요소 보다 작으면 push로 맨 앞의 요소를 뒤로 보낸다.
 * 3. loop를 돌다가 max 요소보다 작지 않으면 front 요소라는 뜻이고, shift하여 없앤다.
 * 4. count++를 해주고, 없앤 요소가 찾고 싶던 우선 순위 요소인지 확인한다.
 * 5. arr에 요소가 없어질 때까지 loop를 돌며 찾는다.
 */
