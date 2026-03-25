package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.MAX_VALUE;

public class BaekJoon_11403 {
    static int N;
    static int[][] stated;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        stated = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                stated[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                for (int c = 0; c < N; c++) {
                    if (stated[b][a] == 1 && stated[a][c] == 1){
                        stated[b][c] = 1;
                        }

                    // 왜...왜....안 될까..
                    // 안 되는거다.. 그냥 외워라 이건,,
//                    if (stated[a][b] == 1 && stated[b][c] == 1){
//                        stated[a][c] = 1;
//                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(stated[i][j] + " ");
            }
            System.out.println();
        }
    }
}
