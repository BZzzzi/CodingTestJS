package BeakJoon_Dijkstra;

import java.io.*;
import java.util.*;

// 아무 노드로 시작 했어도 답이 나온다.
// 그 노드에서 가장 먼 노드를 찾고 거기서 또 다시 먼 노드를 찾으면 된다.
// 트리는 노드가 없음
public class BaekJoon_1967 {
    static class Node implements Comparable<Node> {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int N;
    static List<List<Node>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree.get(parent).add(new Node(child, cost));
            tree.get(child).add(new Node(parent, cost));
        }

        Node farNode = dijkstra(1);
        Node result = dijkstra(farNode.vertex);
        System.out.println(result.cost);
    }

    static Node dijkstra(int start) {
        int[] checkArray = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(checkArray, Integer.MAX_VALUE);
        checkArray[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.vertex]) continue;
            visited[now.vertex] = true;

            for (Node next : tree.get(now.vertex)) {
                if (!visited[next.vertex] && checkArray[next.vertex] > checkArray[now.vertex] + next.cost) {
                    checkArray[next.vertex] = checkArray[now.vertex] + next.cost;
                    pq.offer(new Node(next.vertex, checkArray[next.vertex]));
                }
            }
        }

        int maxCost = 0;
        int farthestNode = start;
        for (int i = 1; i <= N; i++) {
            if (checkArray[i] != Integer.MAX_VALUE && checkArray[i] > maxCost) {
                maxCost = checkArray[i];
                farthestNode = i;
            }
        }
        return new Node(farthestNode, maxCost);
    }
}
