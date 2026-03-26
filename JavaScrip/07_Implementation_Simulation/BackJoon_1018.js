const fs = require("fs");
const rawInput = fs.readFileSync("./input.txt").toString().trim().split(/\s+/);
const row = Number(rawInput[0]);
const col = Number(rawInput[1]);

const processedInput = rawInput.splice(2).map((row) => row.split(""));

const BArr = [];
const WArr = [];

for (let i = 0; i < 8; i++) {
  BArr[i] = [];
  WArr[i] = [];
  for (let j = 0; j < 8; j++) {
    if ((i + j) % 2 === 0) {
      BArr[i][j] = "B";
      WArr[i][j] = "W";
    } else {
      BArr[i][j] = "W";
      WArr[i][j] = "B";
    }
  }
}

let answer = 2501;

for (let rowStart = 0; rowStart <= row - 8; rowStart++) {
  for (let colStart = 0; colStart <= col - 8; colStart++) {
    let Bcheck = 0;
    let Wcheck = 0;
    for (let i = 0; i < 8; i++) {
      for (let j = 0; j < 8; j++) {
        if (processedInput[rowStart + i][colStart + j] !== BArr[i][j]) {
          Bcheck++;
        }
        if (processedInput[rowStart + i][colStart + j] !== WArr[i][j]) {
          Wcheck++;
        }
      }
    }
    const blockMin = Math.min(Bcheck, Wcheck);
    if (blockMin < answer) answer = blockMin;
  }
}

console.log(answer);

/**
 * 링크: https://www.acmicpc.net/problem/1018
 * 1. 2중 배열을 8칸씩을 비교해야 하는 문제인데 row, col 위치를 고정시키고 비교해나가는 것이 어려웠다.
 * 2. 위치를 고정하고 비교하는 작업을 디버깅 하는 것이 오래 걸렸다.
 */
