const fs = require("fs");
const rawInput = fs.readFileSync("./input.txt").toString().trim().split(`\n`);
const processedInput = rawInput.slice(1).map(Number);

const stack = [];
const stackResult = [];

let stackNum = 1;
let inputNum = 0;

while (inputNum < rawInput[0]) {
  while (stackNum <= processedInput[inputNum]) {
    stack.push(stackNum);
    stackResult.push("+");
    stackNum++;
  }
  if (stack[stack.length - 1] === processedInput[inputNum]) {
    stack.pop();
    stackResult.push("-");
    inputNum++;
  } else {
    console.log("NO");
    return;
  }
}

for (i of stackResult) console.log(i);

/**
 * 링크: https://www.acmicpc.net/problem/1874
 * 1. stackTop을 뽑아 input 요소를 차례로 비교하는 인사이트를 찾기 어려웠다.
 * 2. processedInput[inputNum]이 stackNum 보다 작으면 비교할 필요가 없다.
 * 3. stackNum이 이미 비교를 했었으면 check배열에 stackNum 인덱스로 조건을 비교했으나 복잡하고 불필요한 걸 알았다.
 * 4. processedInput[inputNum]이 작을 때만 while문이 동작하도록 로직을 개선했다.
 */
