package BeakJoon_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class BaekJoon_13549 {
    static class Node implements Comparable<Node> {
        int vertex, cost;

        Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.cost, other.cost); // 가중치 오름차순
        }
    }

    static int N, K;
    static int[] costArray = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(Dijkstrapq(N, K));
    }
    private static int Dijkstrapq(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[100001];
        Arrays.fill(costArray, MAX_VALUE);

        pq.offer(new Node(start, 0));
        costArray[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if (!visited[now.vertex]) continue;
            visited[now.vertex] = true;

            if (now.vertex == end) return now.cost;

            if (now.vertex * 2 <= 100000 && costArray[now.vertex * 2] > now.cost) {
                costArray[now.vertex * 2] = now.cost;
                pq.offer(new Node(now.vertex * 2, now.cost));
            };
            if (now.vertex + 1 <= 100000 && costArray[now.vertex + 1] > now.cost + 1) {
                costArray[now.vertex + 1] = now.cost + 1;
                pq.offer(new Node(now.vertex + 1, now.cost + 1));
            };
            if (now.vertex - 1 >= 0 && costArray[now.vertex - 1] > now.cost + 1) {
                costArray[now.vertex - 1] = now.cost + 1;
                pq.offer(new Node(now.vertex - 1, now.cost + 1));
            };
        }
        return -1;
    }
}
