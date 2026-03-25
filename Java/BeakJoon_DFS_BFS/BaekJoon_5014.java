package BeakJoon_DFS_BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_5014 {
    // F - 총 건물층
    // S - 현 위치
    // G - 가야할 층
    // U - 위로
    // D - 아래로
    static int F, S, G, U, D;
    static int upLimitedFloor, downLimitedFloor;
    static boolean[] visited;
    static int[] upArray;
    static int[] downArray;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int result = bfs(S);
        System.out.println(result == -1 ? "use the stairs" : result);
    }

    private static int bfs(int start){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];
        visited[start] = true;
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            if (now[0] == G) return now[1];

            int upNum = now[0] + U;
            int downNum = now[0] - D;

            if (1 <= downNum && !visited[downNum]) {
                visited[downNum] = true;
                queue.offer(new int[]{downNum, now[1] + 1});
            }

            if (F >= upNum && !visited[upNum]) {
                visited[upNum] = true;
                queue.offer(new int[]{upNum, now[1] + 1});
            }
        }
        return -1;
    }
}