const fs = require("fs");
const input = fs.readFileSync("./input.txt").toString().trim().split(" ");

let count = 0;

for (i of input) {
  if (i !== "") {
    count++;
  }
}

console.log(count);

/**
 * 링크: https://www.acmicpc.net/problem/1152
 * 1. 중간에 공백이 있는 TestCase는 공백까지 배열의 요소로 들어가는 문제가 생긴다.
 * 2. 공백 요소를 제외하고 문자열 요소가 있는 것을 카운팅하여 해결
 */
