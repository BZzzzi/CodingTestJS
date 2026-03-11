const fs = require("fs");
let input = fs.readFileSync("./input.txt").toString().trim().split(/\s+/);

const T = input[0];

for (let i = 1; i <= T; i++) {
  let tempArr = [];
  let check = 0;

  for (let j = 0; j < input[i].length; j++) {
    if (input[i][j] === "(") {
      tempArr.push(input[i][j]);
    } else if (input[i][j] === ")" && tempArr.length <= 0) {
      check = 0;
      break;
    } else {
      tempArr.pop(input[i][j]);
      check = 1;
    }
  }

  if (check === 0 || tempArr.length > 0) {
    console.log("NO");
  } else {
    console.log("YES");
  }
}

/**
 * 링크: https://www.acmicpc.net/problem/9012
 * - 열린 괄호와 닫힌 괄호 개수만 맞으면 되는 줄 알았으나,
 * - 개수는 맞지만 순서가 잘못된 경우가 있기 때문에 스택으로 해결
 */
