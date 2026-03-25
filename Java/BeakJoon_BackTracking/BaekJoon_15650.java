package BeakJoon_BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_15650 {
    static int N, M;
    static int[] stated;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stated = new int[N + 1];
        visited = new boolean[N + 1];
        backTracking(0);
    }
    private static void backTracking(int count){
        if (count == M){
            for (int i = 1; i <= count; i++) {
                System.out.print(stated[i] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                visited[i] = true;
                stated[count + 1] = i;
                backTracking(count + 1);
                visited[i] = false;
            }
        }
    }
}
