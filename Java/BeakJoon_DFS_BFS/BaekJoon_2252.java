package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상 정렬이란
//

public class BaekJoon_2252 {
    static int N, M, A, B;
    static List<List<Integer>> list;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);
            visited[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> outputList = new ArrayList<>();

        for (int i = 1; i <= N ; i++) {
            if (visited[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int now = queue.poll();
            outputList.add(now);

            for (int listNum : list.get(now)){
                visited[listNum]--;
                if (visited[listNum] == 0){
                    queue.offer(listNum);
                }
            }
        }

        for (int i : outputList) {
            System.out.print(i + " ");
        }
    }
}
