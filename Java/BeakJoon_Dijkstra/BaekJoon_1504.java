package BeakJoon_Dijkstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon_1504 {
    static class Node implements Comparable<Node>{
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }

    static int N, E, v1, v2;
    static List<List<Node>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E ; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }
//        System.out.println();
//
//        for (int i = 0; i <= N; i++) {
//            System.out.println("i = " + i);
//            for (Node j: list.get(i)){
//                System.out.println("vertex: " + j.vertex + ", cost: " + j.cost);
//            }
//            System.out.println();
//        }

        st = new StringTokenizer(bf.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int[] temp1 = dijkstra(1);
        int[] temp2 = dijkstra(v1);
        int[] temp3 = dijkstra(v2);

        int tempResult1 = temp1[v1] + temp2[v2] + temp3[N];
        int tempResult2 = temp1[v2] + temp3[v1] + temp2[N];
        int result = Math.min(tempResult1, tempResult2);

        System.out.println(result >= 200000000 ? -1 : result);
    }

    private static int[] dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int[] temp = new int[N + 1];
        Arrays.fill(temp, 200000000);
        temp[start] = 0;

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if (temp[now.vertex] < now.cost) continue;
            for (Node next : list.get(now.vertex)){
                if (next.cost + now.cost < temp[next.vertex]){
                    temp[next.vertex] = next.cost + now.cost;
                    pq.offer(new Node(next.vertex, temp[next.vertex]));
                }
            }
        }
        return temp;
    }
}
