package BeakJoon_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon_13460 {
    // . 은 빈칸
    // # 은 장애물 벽
    // 0 은 구멍 위치
    // R 은 빨간 구슬
    // B 는 파란 구슬
    
    // 인사이트
    // 빨간 구슬이 장애물 벽을 만날 때 까지 전진 - 이를 1회로 지정
    // 파란 구슬도 같이 움직이긴 한다.
    // 구슬은 겹쳐지면 안 된다.

    // 예외 처리
    // 구멍 앞에 빨간 구슬과 파란 구슬의 차이 만큼 빈 칸이 존재 + 장애물 없이 붙어 있음 - 파란 구슬이 같이 들어 간다. -1
    // 빨간 구슬이 10회 이하로 못 나오면 -1
    // 빨간 구슬이 장애물에 막혀 구멍에 도달하지 못한다. -1
    // 파란 공이 먼저 빠지면 -1

    // 팁 - 좌우 1번 하면 상하로 해라

    static int N, M;
    static String[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
//                map[i][j] = String.valueOf(st.charAt(line));
            }
        }
    }
}



