package BeakJoon_Dijkstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class BaekJoon_1753_ver2 {
    static class Node implements Comparable<Node> {
        int vertex, cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost); // 가중치 오름차순, 최소 힙
        }
    }

    static int V, E, K;
    static List<List<Node>> list;
    static int[] stated;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(bf.readLine());

        list = new ArrayList<>(V + 1);
        stated = new int[V + 1];
        Arrays.fill(stated, MAX_VALUE);

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int charge = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, charge));
        }

        for (int i = 0; i <= V; i++){
            System.out.print(i + "번 째: ");
            for (Node node : list.get(i)){
                System.out.print(node.vertex + ", " + node.cost);
                System.out.print(" / ");
            }
            System.out.println();
        }

        pq(K);
        for (int i = 1; i <= V; i++){
            System.out.println(stated[i] == MAX_VALUE ? "INF" : stated[i]);
        }
    }
    private static void pq(int k){
        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        pqueue.offer(new Node(k, 0));
        stated[k] = 0;

        while(!pqueue.isEmpty()){
            Node now = pqueue.poll();
            if(now.cost > stated[now.vertex]) continue;

            for (Node next : list.get(now.vertex)) {
                int temp = next.cost + now.cost;
                if (stated[next.vertex] > temp){
                    stated[next.vertex] = temp;
                    pqueue.offer(new Node(next.vertex, temp));
                }
            }
        }
    }
}



