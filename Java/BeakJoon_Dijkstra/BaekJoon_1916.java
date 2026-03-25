package BeakJoon_Dijkstra;

import java.io.*;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class BaekJoon_1916 {
    static class Dijkstra implements Comparable<Dijkstra>{
        int vertex, cost;

        Dijkstra(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Dijkstra other){
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int N, M, startCity, endCity;
    static int stated[];
    static List<List<Dijkstra>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        list = new ArrayList<>(N + 1);
        stated = new int[N + 1];
        Arrays.fill(stated, MAX_VALUE);

        for (int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Dijkstra(b, c));
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++){
            System.out.print(i + ": ");
            for (Dijkstra dijkstra : list.get(i)){
                System.out.print(dijkstra.vertex + ", " + dijkstra.cost + "/ ");
            }
            System.out.println();
        }

        dijk(startCity);

        for (int i = 0; i <= N; i++){
            System.out.println("stated = " + stated[i]);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(stated[endCity]));
        bw.flush(); // 출력 버퍼 비우기
        bw.close(); // 스트림 닫기
    }
    private static void dijk(int start){
        PriorityQueue<Dijkstra> pq = new PriorityQueue<>();
        pq.offer(new Dijkstra(start, 0));
        stated[start] = 0;


        while (!pq.isEmpty()){
            Dijkstra now = pq.poll();
            if (stated[now.vertex] < now.cost) continue; // 이거 없으면 시간 초과 난다.

            for (Dijkstra dijkstra : list.get(now.vertex)){
                if (stated[dijkstra.vertex] > stated[now.vertex] + dijkstra.cost){
                    stated[dijkstra.vertex] = stated[now.vertex] + dijkstra.cost;
                    pq.offer(new Dijkstra(dijkstra.vertex, stated[dijkstra.vertex]));
                }
            }
        }
    }
}