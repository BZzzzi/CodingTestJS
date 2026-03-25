package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class BaekJoon_2644 {
    static int n, m, inputX, inputY;
    static boolean[] visited;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        inputX = Integer.parseInt(st.nextToken());
        inputY = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(bf.readLine());

        visited = new boolean[n + 1];
        list = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list.get(parent).add(child);
            list.get(child).add(parent);
        }

//        for (int i = 0; i <= n; i++) {
//            System.out.print(i + " = ");
//            for (int a : list.get(i)){
//                System.out.print(a + ", ");
//            }
//            System.out.println();
//        }

        System.out.println(bfs(inputX));
    }
    private static int bfs(int input){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{input, 0});
        visited[input] = true;

        while(!queue.isEmpty()){
            int[] a = queue.poll();
            int node = a[0];
            int count = a[1];

            if(node == inputY) return count;

            for(int now : list.get(a[0])){
                if (!visited[now]) {
                    queue.offer(new int[]{now, count + 1});
                    visited[now] = true;
                }
            }
        }
        return -1;
    }
}
