package BeakJoon_DFS_BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2573 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int yearCount = 0;

        while(true){
            int[][] melt = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0){
                        for (int k = 0; k < 4; k++) {
                            int nX = i + dX[k];
                            int nY = j + dY[k];
                            if(0 <= nX && nX < N && 0 <= nY && nY < M && map[nX][nY] == 0){
                                melt[i][j]++;
                            }
                        }
                    }
                }
            }

            boolean checkMountain = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (melt[i][j] > 0){
                        map[i][j] -= melt[i][j];
                        if(map[i][j] < 0) map[i][j] = 0;
                    }
                    if(map[i][j] > 0) checkMountain = true;
                }
            }

            yearCount++;

            if (!checkMountain) {
                System.out.println(0);
                return;
            }

            int checkCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]){
                        checkBFS(i, j);
                        checkCount++;
                    }
                }
            }

            if (checkCount > 1) {
                System.out.println(yearCount);
                return;
            }
        }
    }

    private static void checkBFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nX = now.x + dX[i];
                int nY = now.y + dY[i];
                if(0 <= nX && nX < N && 0 <= nY && nY < M && map[nX][nY] > 0 && !visited[nX][nY]){
                    queue.offer(new Point(nX, nY));
                    visited[nX][nY] = true;
                }
            }
        }
    }
}
