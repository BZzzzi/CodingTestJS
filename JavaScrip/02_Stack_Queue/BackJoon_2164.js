const fs = require("fs");
const input = fs.readFileSync("./input.txt").toString().trim().split(/\s+/);

let arr = [];

for (let i = 1; i <= input; i++) {
  arr[i - 1] = i;
}

let head = 0;
let tail = input;

while (tail - head > 1) {
  head++;
  arr[tail] = arr[head];
  head++;
  tail++;
}

console.log(arr[head]);

/**
 * 링크: https://www.acmicpc.net/problem/2164
 * - shift()는 O(N) 시간 복잡도로 시간 초과 발생
 * - slice()는 배열 복사로 인한 메모리 초과 발생
 * - 배열을 건들지 않고 head, tail만을 이용해 마지막에 남는 숫자 도출
 */
