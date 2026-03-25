package BeakJoon_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon_1238 {
    static class Dijkstra implements Comparable<Dijkstra>{
        int vertax, cost;

        public Dijkstra(int vertax, int cost){
            this.vertax = vertax;
            this.cost = cost;
        }

        @Override
        public int compareTo(Dijkstra other){
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int N, M, X;
    static List<List<Dijkstra>> list;
    static int[][] costArray;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        temp = new int[N + 1];
        costArray = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N ; j++) {
                costArray[i][j] = 999999;
            }
        }

        list = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            list.get(A).add(new Dijkstra(B, T));
        }

        for (int i = 0; i <= N; i++) {
            System.out.println(i + "번째 리스트");
            for (Dijkstra a: list.get(i)){
                System.out.println(a.vertax + ", " + a.cost);
            }
            System.out.println();
        }

        dk(X);
        int maxValue = 0;

        for (int i = 1; i <= N; i++) {
            if (maxValue <= temp[i]) maxValue = temp[i];
        }
        System.out.println(maxValue);
    }
    private static void dk(int startNode){
        PriorityQueue<Dijkstra> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
        pq.offer(new Dijkstra(i, 0));
        costArray[i][i] = 0; // 나에서 나로 가는 거
            while(!pq.isEmpty()){
                Dijkstra now = pq.poll();
                if (costArray[i][now.vertax] < now.cost) continue;

                for (Dijkstra next : list.get(now.vertax)){
                    if (costArray[i][now.vertax] + next.cost < costArray[i][next.vertax]){
                        costArray[i][next.vertax] = costArray[i][now.vertax] + next.cost;
                        pq.offer(new Dijkstra(next.vertax, costArray[i][next.vertax]));
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            temp[i] = costArray[i][startNode] + costArray[startNode][i];
        }
    }
}



