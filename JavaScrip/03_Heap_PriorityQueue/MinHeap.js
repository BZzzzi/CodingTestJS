class MinHeap {
  constructor() {
    this.heap = [];
  }

  size() {
    return this.heap.length;
  }

  // 요소 추가
  push(value) {
    this.heap.push(value);
  }

  // 위로 올라가며 자리 찾기
  bubbleUp() {
    let index = this.heap.length - 1;

    while (index > 0) {
      const parentIndex = Math.floor((index - 1) / 2);
      if (this.heap[parentIndex] <= this.heap[index]) break;

      // 부모보다 내가 더 작으면 swap
      [this.heap[parentIndex], this.heap[index]] = [
        this.heap[index],
        this.heap[parentIndex],
      ];
    }
  }

  // 요소 삭제(루트 삭제)

  bubbleDown() {
    let index = 0;
    const length = this.heap.length;

    while (true) {
      let leftChildIndex = index * 2 + 1;
      let rightChildIndex = index * 2 + 2;
      let smallest = index;

      // 왼쪽 자식이
    }
  }
}
