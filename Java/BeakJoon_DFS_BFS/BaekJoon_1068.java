package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1068 {
    static int N, removeNode;
    static int[] stated;
    static boolean[] check;
    static List<List<Integer>> Node;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        stated = new int[N];
        check = new boolean[N];
        Node = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            Node.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            stated[i] = temp;
        }

        for (int i = 0; i < N; i++) {
            if (stated[i] == -1) continue;
            Node.get(stated[i]).add(i);
        }

        removeNode = Integer.parseInt(bf.readLine());

        BFS(removeNode);

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (!check[i] && Node.get(i).size() == 0) result++;
        }

        System.out.println(result);
    }

    public static void BFS(int removeNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(removeNode);
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int n : Node.get(now)){
                queue.offer(n);
            }
            for (int i = 0; i < N; i++){
                // Node.get(i).remove(now);
                // 이렇게 하면 'remove(int index)'로 인식돼서 인덱스를 삭제하게 된다.
                // Integer.valueOf(now)로 감싸야 'remove(Object o)'로 인식되어 값을 삭제할 수 있다.
                Node.get(i).remove(Integer.valueOf(now));
            }
            check[now] = true;
        }
    }
}



