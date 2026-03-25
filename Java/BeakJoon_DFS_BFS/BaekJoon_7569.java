package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PointThree{
    int z, y, x;

    public PointThree(int z, int y, int x){
        this.z = z;
        this.y = y;
        this.x = x;
    }
}

public class BaekJoon_7569 {
    static int M, N, H, count = 0;
    static int[][][] stated;
    static boolean[][][] visited;
    static boolean dayCount;
    static Queue<PointThree> queue = new LinkedList<>();


    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        stated = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < M; k++) {
                    stated[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

//        for (int i = 0; i < H; i++) {
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(stated[i][j][k]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        visited = new boolean[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (stated[i][j][k] == 1) {
                        queue.offer(new PointThree(i, j, k));
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        bfs(queue);

    }

    private static void bfs(Queue<PointThree> queue){
        int[] nx = {0, 0, -1, 1, 0, 0};
        int[] ny = {-1, 1, 0, 0, 0, 0};
        int[] nz = {0, 0, 0, 0, -1, 1};
        int dx, dy, dz;
        while (!queue.isEmpty()){
            dayCount = false;
            int size = queue.size();
            for (int l = 0; l < size; l++) {
                PointThree now = queue.poll();
                for (int f = 0; f < 6; f++) {
                    dx = now.x + nx[f];
                    dy = now.y + ny[f];
                    dz = now.z + nz[f];
                    if (0 <= dx && dx < M && 0 <= dy && dy < N && 0 <= dz && dz < H && stated[dz][dy][dx] == 0 && !visited[dz][dy][dx]){
//                        System.out.print("zyx = " + dz);
//                        System.out.print(dy);
//                        System.out.println(dx);
                        stated[dz][dy][dx] = 1;
                        queue.offer(new PointThree(dz, dy, dx));
                        visited[dz][dy][dx] = true;
                        dayCount = true;
                    }
                }
            }
            if (dayCount){
                count++;
//                System.out.println("count = " + count);
            }
        }
        for (int a = 0; a < H; a++) {
            for (int b = 0; b < N; b++) {
                for (int c = 0; c < M; c++) {
                    if (stated[a][b][c] == 0) {
                        count = -1;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
