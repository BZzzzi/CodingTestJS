package BeakJoon_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BeakJoon_1922 {
    static class Node implements Comparable<Node>{
        int vertex, cost;

        public Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static List<List<Node>> computer;
    static int[] costArray;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        computer = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            computer.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            computer.get(a).add(new Node(b, c));
            computer.get(b).add(new Node(a, c));
        }

        int result = bfs(1);
        System.out.println(result);
    }

    private static int bfs(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        visited = new boolean[N + 1];
        int result = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if (visited[now.vertex]) continue;
            visited[now.vertex] = true;

            result += now.cost;

            for (Node next : computer.get(now.vertex)){
                if (!visited[next.vertex]){
                    pq.offer(new Node(next.vertex, next.cost));
                }
            }
        }
        return result;
    }
}
