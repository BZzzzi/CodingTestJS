package BeakJoon_DFS_BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_16234 {
    static int N, L, R, dayCount = 0;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        while (true){
            visited = new boolean[N][N];
            boolean move = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]){
                        if (bfs(i, j)){
                            move = true;
                        }
                    }
                }
            }

            if (!move) break;
            dayCount++;
        }

        System.out.println(dayCount);
    }
    private static boolean bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        List<Point> list = new ArrayList<>();
        int daySum = map[x][y];
        int daySumCount = 1;

        queue.offer(new Point(x, y));
        list.add(new Point(x, y));
        visited[x][y] = true;

        int[] dX = {0, 0, -1, 1};
        int[] dY = {-1, 1, 0, 0};

        while (!queue.isEmpty()){
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nX = now.x + dX[i];
                int nY = now.y + dY[i];

                if(0 <= nX && nX < N && 0 <= nY && nY < N && !visited[nX][nY]){
                    int temp = Math.abs(map[now.x][now.y] - map[nX][nY]);
                    if (L <= temp && temp <= R){
                        queue.offer(new Point(nX, nY));
                        list.add(new Point(nX, nY));
                        visited[nX][nY] = true;
                        daySum += map[nX][nY];
                        daySumCount++;
                    }
                }
            }
        }

        if (daySumCount == 1) return false;

        int dayResult = daySum / daySumCount;
        for (Point a : list){
            map[a.x][a.y] = dayResult;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        return true;
    }
}



