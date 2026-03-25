package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

public class BaekJoon_1389 {
    static int N, M, INF = 999999;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A][B] = 1;
            map[B][A] = 1;
        }

        for (int node = 0; node <= N; node++) {
            for (int i = 0; i <= N; i++) {
                for (int j =0; j <= N; j++) {
                    if (map[i][j] > map[i][node] + map[node][j]){
                        map[i][j] = map[i][node] + map[node][j];
                    }
                }
            }
        }

        int[] temp = new int[N+1];
        int minNum = MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) map[i][j] = 0;
                temp[i] += map[i][j];
            }
            minNum = Math.min(temp[i], minNum);
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (minNum == temp[i]) {
                result = i;
                break;
            };
        }
        System.out.println(result);
    }
}
