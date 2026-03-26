const fs = require("fs");
const rawInput = fs.readFileSync("./input.txt").toString().trim().split(/\s+/);
const processedInput = rawInput.slice(1).map((item) => {
  return isNaN(item * 1) ? item : item * 1;
});

let idx = 0;
const checkArr = [];

for (let i = 0; i < rawInput[0]; i++) {
  switch (processedInput[idx]) {
    case "push":
      checkArr.push(processedInput[idx + 1]);
      idx += 2;
      break;
    case "pop":
      if (checkArr.length <= 0) {
        console.log(-1);
      } else {
        console.log(checkArr.pop());
      }
      idx++;
      break;
    case "size":
      console.log(checkArr.length);
      idx++;
      break;
    case "empty":
      if (checkArr.length <= 0) {
        console.log(1);
      } else {
        console.log(0);
      }
      idx++;
      break;
    case "top":
      if (checkArr.length <= 0) {
        console.log(-1);
      } else {
        console.log(checkArr[checkArr.length - 1]);
      }
      idx++;
      break;
  }
}

/**
 * 링크: https://www.acmicpc.net/problem/10828
 * 1. 명령어와 push 숫자를 구분해서 배열에 저장한다.
 * 2. 명령어 순서대로 switch문으로 처리해주면 쉽게 풀리는 문제
 * 3. LIFO 규칙을 적용하면 된다.
 */
