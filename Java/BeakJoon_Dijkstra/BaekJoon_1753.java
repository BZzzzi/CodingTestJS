package BeakJoon_Dijkstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;


public class BaekJoon_1753 {
    static class Node implements Comparable<Node>{
        int vertex, weight;

        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.weight, other.weight); // 가중치 오름차순 정렬 (최소 힙)
        }
    }

    static int V, E, K;
    static List<List<Node>> list;
    static int[] result;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(bf.readLine());

        list = new ArrayList<>(V + 1);
        result = new int[V + 1];
        Arrays.fill(result, INF);

        for (int i = 0; i <= V; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, cost));
        }

        for (int i = 1; i <= V; i++) {
            System.out.print(i + ": ");
            for (Node node : list.get(i)) {
                System.out.print(node.vertex + ", " + node.weight + " / ");
            }
            System.out.println();
        }

//        {
//            [],          // index 0 (사용하지 않음, 1-based index)
//            [ (2,2), (3,3) ],  // 1번 정점 → (2번 정점, 가중치 2), (3번 정점, 가중치 3)
//            [ (3,4), (4,5) ],  // 2번 정점 → (3번 정점, 가중치 4), (4번 정점, 가중치 5)
//            [ (4,6) ],        // 3번 정점 → (4번 정점, 가중치 6)
//            [],               // 4번 정점 → (비어있음)
//            []                // 5번 정점 → (비어있음)
//        }

        dijkstra(K);
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(result[i] == INF ? "INF" : result[i]).append("\n");
        }
        System.out.print(sb);

    }

    private static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));
        result[k] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int nowVertex = now.vertex;
            int nowWeight = now.weight;

            if (nowWeight > result[nowVertex]) continue;  // 최적 거리보다 크면 무시

            for (Node next : list.get(nowVertex)){
                int newResult = result[nowVertex] + next.weight;
                if (newResult < result[next.vertex]){
                    result[next.vertex] = newResult;
                    pq.offer(new Node(next.vertex, newResult));
                }
            }
        }
    }
}



