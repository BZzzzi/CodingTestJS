package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1697 {
    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N, K);
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();

                if (now == k) {
                    System.out.println(time);
                    return;
                }

                int numArray[] = {(now - 1),(now + 1),(now * 2)};
                for (int num : numArray) {
                    if (0 <= num && num <= 100000 && !visited[num]) {
                        queue.offer(num);
                        visited[num] = true;
                    }
                }
            } time++;
        }
    }
}
