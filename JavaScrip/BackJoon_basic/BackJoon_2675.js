let fs = require("fs");
let input = fs.readFileSync("./input.txt").toString().split("\n");

let T = Number(input[0]);

for (let i = 1; i <= T; i++) {
  // 구조분해할당, 공백을 기준으로 R, S에 각각 할당
  const [R, S] = input[i].split(" ");
  let result = "";

  for (let char of S) {
    // R 만큼 반복해서 result에 글자를 더해라
    result += char.repeat(Number(R));
  }

  console.log(result);
}
