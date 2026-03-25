package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_17070 {
    static class Pipe{
        int r, c, dir;
        public Pipe(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    static int N;
    static int col = 0, row = 1, dia = 2;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[N][N] == 1) {
            System.out.println(0);
            return;
        }
        BFS();
    }
    private static void BFS(){
        Queue<Pipe> queue = new LinkedList<>();
        queue.offer(new Pipe(1, 2, col));
        int result = 0;

        while(!queue.isEmpty()){
            Pipe now = queue.poll();
            if (now.r == N && now.c == N){
                result++;
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (now.dir == row && i == col) continue;
                else if (now.dir == col && i == row) continue;
                if (i == row && (now.r + 1) <= N && map[now.r + 1][now.c] != 1){
                    queue.offer(new Pipe(now.r + 1, now.c, row));
                }
                if (i == col && (now.c + 1) <= N && map[now.r][now.c + 1] != 1){
                    queue.offer(new Pipe(now.r, now.c + 1, col));
                }
                if (i == dia && (now.r + 1) <= N && (now.c + 1) <= N && map[now.r][now.c + 1] != 1 && map[now.r + 1][now.c] != 1 && map[now.r + 1][now.c + 1] != 1){
                    queue.offer(new Pipe(now.r + 1, now.c + 1, dia));
                }
            }
        }
        System.out.println(result);
    }
}
