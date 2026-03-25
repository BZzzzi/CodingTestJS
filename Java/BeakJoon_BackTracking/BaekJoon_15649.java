package BeakJoon_BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon_15649 {
    static int N, M;
    static int[] stated;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stated = new int[M];
        visited = new boolean[N + 1];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        backTracking(0);

        bw.flush();
        bw.close();
    }
    private static void backTracking(int count) throws IOException {
        // 1. count = 0
        // 2. count = 1
        // 3. count = 2
        // 4. count = 2
        if (count == M){
            // 3. count가 2이므로 출력
            // 4. count가 2이므로 출력
            for (int i = 0; i < M; i++) {
                bw.write(stated[i] + " ");
            }
            bw.newLine();
            return;
            // 3. 1 2 출력
            // 4. 1 3 출력

            // 3. backTracking(2) 종료
            // 4. backTracking(2) 종료
        }

        for (int i = 1; i <= N; i++) {
            // 1. i = 1
            // 2. i = 2
            // 4. i = 3
            if(!visited[i]){
                visited[i] = true;
                // 1. visited[1] = true
                // 2. visited[2] = true
                // 4. visited[3] = true
                stated[count] = i;
                // 1. stated[0] = 1
                // 2. stated[1] = 2
                // 4. stated[1] = 3
                backTracking(count + 1);
                // 1. backTracking에 1 넣음
                // 2. backTracking에 2 넣음
                // 4. backTracking에 2 넣음
                visited[i] = false;
                // 3. visited[2] = false
                // 4. count = 1이 아직 안 끝났기 때문에 for문으로 돌아간다.
                // 4. visited[3] = false
                // 5. count = 1이 아직 안 끝났기 때문에 for문으로 돌아가는 것을 반복한다.
            }
        }
    }
}
