package BeakJoon_DFS_BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_1167 {
    static int V, maxIndex, maxNum;
    static List<List<Point>> list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        V = Integer.parseInt(st.nextToken());

        list = new ArrayList<>(V + 1);

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true){
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;
                int c = Integer.parseInt(st.nextToken());
                list.get(a).add(new Point(b, c));
                list.get(b).add(new Point(a, c));
            }
        }

        visited = new boolean[V + 1];
        maxNum = 0;
        DFS(1, 0);

        visited = new boolean[V + 1];
        maxNum = 0;
        DFS(maxIndex, 0);

        System.out.println(maxNum);
    }
    private static void DFS(int start, int cost) {
        visited[start] = true;

        if (cost > maxNum){
            maxNum = cost;
            maxIndex = start;
        }

        for (Point next: list.get(start)){
            if (!visited[next.x]){
                DFS(next.x, cost + next.y);
            }
        }
    }
}
