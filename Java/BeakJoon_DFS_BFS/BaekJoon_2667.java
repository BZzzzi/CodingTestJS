package BeakJoon_DFS_BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2667 {
    static int N;
    static int count = 0;
    static int[][] array = new int[N][N];
    static int[] countFloor = new int[N*N];
    static boolean[][] visited = new boolean[N][N];

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        array = new int[N][N];
        for (int i = 0; i < N; i++) {
            String temp = bf.readLine();
            for (int j = 0; j < temp.length(); j++) {
                array[i][j] = temp.charAt(j) - '0';
                // Hello에서 charAt(0)이면 H를 반환
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j]);
            }
        System.out.println();
        }

        countFloor = new int[N*N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println("count " + count);
        Arrays.sort(countFloor, 0, count);
        for (int i = 0; i < count; i++) {
            System.out.println(countFloor[i]);
        }
    }

    private static void bfs(int i, int j) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
//        visited = new boolean[N][N]; 이거 때매 방문 체크 제대로 안 됐음
        visited[i][j] = true;
        int countFloorNum = 1; // 초기 방문 포함

        while(!queue.isEmpty()){
            Point now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && (array[nx][ny] == 1) && (!visited[nx][ny])){
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    countFloorNum++;
                }
            }
        }
        System.out.println("count222 " + count);
        System.out.println("countFloorNum111 " + countFloorNum);
        countFloor[count] = countFloorNum;
        System.out.println("countFloorNum222 " + countFloor[count]);

    }
}
