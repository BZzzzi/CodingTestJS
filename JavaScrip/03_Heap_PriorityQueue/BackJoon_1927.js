const fs = require("fs");
const input = fs
  .readFileSync("../input.txt")
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

class MinHeap {
  constructor() {
    this.heap = [];
  }

  size() {
    return this.heap.length;
  }

  push(value) {
    this.heap.push(value);
    this.bubbleUp();
  }

  bubbleUp() {
    let index = this.size() - 1;

    while (index > 0) {
      const parentIndex = Math.floor((index - 1) / 2);
      if (this.heap[parentIndex] <= this.heap[index]) break;

      [this.heap[parentIndex], this.heap[index]] = [
        this.heap[index],
        this.heap[parentIndex],
      ];
      index = parentIndex;
    }
  }

  pop() {
    if (this.size() === 0) return null;
    if (this.size() === 1) return this.heap.pop();

    const min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown();
    return min;
  }

  bubbleDown() {
    let index = 0;
    const length = this.size();

    while (1) {
      let leftChildIndex = index * 2 + 1;
      let rightChildIndex = index * 2 + 2;
      let smallest = index;

      if (
        leftChildIndex < length &&
        this.heap[leftChildIndex] < this.heap[smallest]
      ) {
        smallest = leftChildIndex;
      }

      if (
        rightChildIndex < length &&
        this.heap[rightChildIndex] < this.heap[smallest]
      ) {
        smallest = rightChildIndex;
      }

      if (smallest === index) break;

      [this.heap[index], this.heap[smallest]] = [
        this.heap[smallest],
        this.heap[index],
      ];
      index = smallest;
    }
  }
}

const n = input[0];
const heap = new MinHeap();
const result = [];

for (let i = 1; i <= n; i++) {
  if (input[i] === 0) {
    result.push(heap.pop() ?? 0);
  } else {
    heap.push(input[i]);
  }
}
console.log(result.join("\n"));

/**
 * 링크: https://www.acmicpc.net/problem/1927
 * 1. 내장 함수 push, pop을 사용하면 정렬 과정이 필수이다.
 * 2. 10만번 O(N)과 정렬 O(N log N)만 해도 벌써 시간 초과 발생
 * 3. 최소 힙으로 자식, 부모 노드를 비교하여 루트 노드에 최솟값이 오도록 구현
 * 4. 시간 복잡도 O(N log N)으로 해결 가능
 * 5. 출력 또한 매번하면 시간 초과이기 때문에 밖으로 뺄 것!
 */
