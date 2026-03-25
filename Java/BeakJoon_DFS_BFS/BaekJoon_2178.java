package BeakJoon_DFS_BFS;

import java.awt.*;
import java.util.*;
import java.io.*;

public class BaekJoon_2178 {
    static int N, M;
    static int[][] stated;
    static boolean[][] visited;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String temp;
        stated = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp = bf.readLine();
            for (int j = 0; j < M; j++) {
                stated[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(distance[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        int dX[] = {0, 0, -1, 1};
        int dY[] = {-1, 1, 0, 0};
        Queue<Point> queue = new LinkedList<>();
        // ArrayList로 안 한 이유는.. 찾아보기
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        distance[x][y] = 1;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            // visited[nX][nY] = true; 이거 여기서 하면 메모리 오버 됨

            for(int i = 0; i < 4; i++){
                int nX = now.x + dX[i]; // 현재 입력은 좌표 + 새로 이동
                int nY = now.y + dY[i]; // 현재 입력은 좌표 + 새로 이동

                if (0 <= nX && nX < N && 0 <= nY && nY < M && stated[nX][nY] == 1 && !visited[nX][nY]){
                    // stated[nX][nY] == 1 이거 먼저하면 범위 밖이면 오류 뜨고 끝나버림
                    visited[nX][nY] = true;
                    distance[nX][nY] = distance[now.x][now.y] + 1;
                    queue.offer(new Point(nX, nY));
                }
            }
        }
    }
}
