package BeakJoon_DFS_BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_11404 {
    static int N, M, INF = 99999999;
    static int[][] stated;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        stated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j){
                    stated[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start =  Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken());
            int cost =  Integer.parseInt(st.nextToken());
            stated[start-1][end-1] = Math.min(stated[start-1][end-1], cost);
        }
        for (int node = 0; node < N; node++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (stated[i][j] > stated[i][node] + stated[node][j]){
                        stated[i][j] = stated[i][node] + stated[node][j];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(stated[i][j] == INF){
                    System.out.print("0 ");
                }else{
                    System.out.print(stated[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
