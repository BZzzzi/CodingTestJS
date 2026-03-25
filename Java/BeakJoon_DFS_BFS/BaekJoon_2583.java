package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2583 {
    static int M, N, K, count = 0, countNum = 0;
    static int[] countNumArray;
    static int[][] stated;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stated = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int leftDownX = Integer.parseInt(st.nextToken());
            int leftDownY = Integer.parseInt(st.nextToken());
            int rightUpX = Integer.parseInt(st.nextToken());
            int rightUpY = Integer.parseInt(st.nextToken());

            for (int y = leftDownY; y < rightUpY; y++) {
                for (int x = leftDownX; x < rightUpX; x++) {
                    stated[y][x] = 1;
                }
            }
        }
        System.out.println();

        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++) {
                System.out.print(stated[i][j]);
            }
            System.out.println();
        }

        countNumArray = new int[M*N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (stated[i][j] == 0 && !visited[i][j]){
                    bfs(i, j);
                    countNumArray[count] = countNum;
                    count++;
                }
            }
        }

        Arrays.sort(countNumArray, 0, count);
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.print(countNumArray[i] + " ");
        }
    }

    private static void bfs(int a, int b){
        Queue<twoPoint> queue = new LinkedList<>();
        queue.offer(new twoPoint(a, b));
        visited[a][b] = true;
        countNum = 1;

        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};
        while(!queue.isEmpty()){
            twoPoint now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < M && 0 <= ny && ny < N && stated[nx][ny] == 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new twoPoint(nx, ny));
                    countNum++;
                }
            }
        }
    }
}
