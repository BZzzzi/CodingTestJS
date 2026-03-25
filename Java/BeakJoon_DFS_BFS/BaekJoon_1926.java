package BeakJoon_DFS_BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1926 {
    static int n, m, count = 0;
    static int[] maxArray;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        maxArray = new int[n * m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1  && !visited[i][j]){
                    bfs(i, j);
                    count++;
                }
            }
        }

        int maxNum = 0;
        for (int i = 0; i < count; i++) {
            if (maxArray[i] > maxNum){
                maxNum = maxArray[i];
            };
        }

        System.out.println(count);
        System.out.print(maxNum);
    }

    private static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        maxArray[count] = 1;

        int[] dX = {0, 0, -1, 1};
        int[] dY = {1, -1, 0, 0};
        while (!queue.isEmpty()){
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nX = now.x + dX[i];
                int nY = now.y + dY[i];
                if (0 <= nX && nX < n && 0 <= nY && nY < m &&  map[nX][nY] == 1 && !visited[nX][nY]){
                    queue.offer(new Point(nX, nY));
                    visited[nX][nY] = true;
                    maxArray[count]++;
                }
            }
        }
    }
}
