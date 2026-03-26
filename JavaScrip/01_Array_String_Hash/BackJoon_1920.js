const fs = require("fs");
const input = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

const Narr = input.slice(1, input[0] + 1).sort((a, b) => a - b);
const Marr = input.slice(input[0] + 2);

function binarySearch(arr, num) {
  let left = 0;
  let right = arr.length - 1;

  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (arr[mid] > num) right = mid - 1;
    else left = mid + 1;
    if (arr[mid] === num) return true;
  }
  return false;
}

for (num of Marr) {
  console.log(binarySearch(Narr, num) ? 1 : 0);
}

/**
 * 링크: https://www.acmicpc.net/problem/1920
 * 1. 시간 복잡도 O(log N) 이진 탐색으로 해결
 * 2. map으로 해도 되지만,, 연습 겸 이진 탐색 활용!
 */
