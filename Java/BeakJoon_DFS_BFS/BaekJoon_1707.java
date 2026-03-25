package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1707 {
    static class BipartiteGraph{
        int vertex;
        String color;

        public BipartiteGraph(int vertex, String color) {
            this.vertex = vertex;
            this.color = color;
        }
    }
    static int K, V, E;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while (0 < K){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList<>(V + 1);
            for (int i = 0; i <= V; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list.get(u).add(v);
                list.get(v).add(u);
            }

            st = new StringTokenizer(bf.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            boolean result = bfs(1);
            System.out.println(result ? "YES" : "NO");
            K--;
        }
    }
    private static boolean bfs(int start){
        Queue<BipartiteGraph> queue = new LinkedList<>();
        queue.offer(new BipartiteGraph(start, "red"));
        boolean[] visited = new boolean[V + 1];
        visited[start] = true;

        boolean result = false;

        while(!queue.isEmpty()){
            BipartiteGraph now = queue.poll();
            for (int next : list.get(now.vertex)){
                queue.offer(new BipartiteGraph(next, "bule"));
                visited[next] = true;
            }
        }
        return result;
    }
}
