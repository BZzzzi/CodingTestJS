package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1260 {
    static int N;
    static int M;
    static int V;
    static boolean[][] state;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        state = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            state[start][end] = true;
            state[end][start] = true;
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();

        visited = new boolean[N+1];
        bfs(V);
    }

    public static void dfs(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i = 1; i <= N; i++) {
            if (state[node][i] && !(visited[i])){
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while(!(queue.isEmpty())){
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i = 1; i <= N; i++) {
                if (state[now][i] && !(visited[i])){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
