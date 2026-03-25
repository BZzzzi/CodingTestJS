package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_11724 {
    static int N, M, count;
    static boolean[] visited;
    static List<List<Integer>> li;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // List 안에 List를 저장하는 형태여야 한다.
        // 그래야 다른 객체를 추가하는 형태가 된다.
        // [[], [], [], [], [], []] 이렇게 출력
        li = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            li.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int str = Integer.parseInt(st.nextToken()) - 1;
            int en = Integer.parseInt(st.nextToken()) - 1;
            li.get(str).add(en + 1);
            li.get(en).add(str + 1);
        }

        visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        visited[num] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for (int temp : li.get(now)){
                if (!visited[temp - 1]){
                    visited[temp - 1] = true;
                    queue.offer(temp - 1);
                }
            }
        }
    }
}
