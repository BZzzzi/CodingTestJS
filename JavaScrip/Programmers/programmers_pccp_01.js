function solution(video_len, pos, op_start, op_end, commands) {
  // 시간 문자열 "mm:ss"를 초 단위 숫자로 변환하는 함수
  function timeToSeconds(time) {
    const [minutes, seconds] = time.split(":").map(Number);
    return minutes * 60 + seconds;
  }

  // 초 단위를 "mm:ss" 문자열로 변환하는 함수
  function secondsToTime(seconds) {
    const minutes = Math.floor(seconds / 60);
    const remainingSeconds = seconds % 60;
    return `${String(minutes).padStart(2, "0")}:${String(remainingSeconds).padStart(2, "0")}`;
  }

  // 입력 값들을 초 단위로 변환
  const videoLength = timeToSeconds(video_len);
  const opStart = timeToSeconds(op_start);
  const opEnd = timeToSeconds(op_end);
  let currentPosition = timeToSeconds(pos);

  // 명령어 처리
  for (const command of commands) {
    if (command === "prev") {
      currentPosition = Math.max(0, currentPosition - 10); // 10초 전으로 이동
    } else if (command === "next") {
      currentPosition = Math.min(videoLength, currentPosition + 10); // 10초 후로 이동
    }

    // 오프닝 건너뛰기
    if (opStart <= currentPosition && currentPosition <= opEnd) {
      currentPosition = opEnd; // 오프닝 끝나는 시각으로 이동
    }
  }

  // 최종 위치를 "mm:ss" 형식으로 반환
  return secondsToTime(currentPosition);
}
const video_len = "01:30";
const pos = "00:05";
const op_start = "00:10";
const op_end = "00:20";
const commands = ["next", "next", "prev", "next"];

console.log(solution(video_len, pos, op_start, op_end, commands));
// 출력: "00:20"
