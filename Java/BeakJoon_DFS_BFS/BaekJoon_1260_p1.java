package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1260_p1 {
    static ArrayList<List<Integer>> arrayList;
    static boolean[] check;
    static int N;
    static int M;
    static int V;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!arrayList.get(a).contains(b)) arrayList.get(a).add(b);
            if (!arrayList.get(b).contains(a)) arrayList.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arrayList.get(i));
        }

        check = new boolean[N + 1];
        DFS(V);

        System.out.println();

        check = new boolean[N + 1];
        BFS(arrayList);
    }

    static void BFS(ArrayList<List<Integer>> arrayList){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        check[V] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");

            for (int temp : arrayList.get(now)){
                if(!check[temp]){
                    queue.offer(temp);
                    check[temp] = true;
                }
            }
        }
    }

    static void DFS(int start){
        check[start] = true;
        System.out.print(start + " ");

        for(int temp : arrayList.get(start)){
            if (!check[temp]){
                DFS(temp);
            }
        }
    }
}
