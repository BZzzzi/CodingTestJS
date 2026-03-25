package BeakJoon_DFS_BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1012 {
    static int M, N, K;
    static int[][] stated = new int[N][M];
    static boolean[][] visited = new boolean[N][M];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        while (T > 0){
            count = 0;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            stated = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(bf.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                stated[e][s] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (stated[i][j] == 1 && !visited[i][j]){
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
            T--;
        }
    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int a = 0; a < 4; a++) {
                int nx = now.x + dx[a];
                int ny = now.y + dy[a];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if (stated[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}



