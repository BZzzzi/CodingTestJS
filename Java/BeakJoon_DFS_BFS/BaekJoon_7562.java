package BeakJoon_DFS_BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class twoPoint{
    int x, y;
    public twoPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon_7562 {
    static int N, I, dx, dy;
    static int[][] stated;
    static boolean[][] visited;
    static twoPoint[] p = {
            new twoPoint(-2, 1),
            new twoPoint(-1, 2),
            new twoPoint(1, 2),
            new twoPoint(2, 1),
            new twoPoint(2, -1),
            new twoPoint(1, -2),
            new twoPoint(-1, -2),
            new twoPoint(-2, -1)
    };

    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine().trim());

        for (int n = 0; n < N; n++) {
            I = Integer.parseInt(bf.readLine().trim());
            stated = new int[I][I];
            visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(bf.readLine().trim());
            int startX = Integer.parseInt(st.nextToken().trim());
            int startY = Integer.parseInt(st.nextToken().trim());

            st = new StringTokenizer(bf.readLine().trim());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            if (startX == endX && startY == endY){
                System.out.println(0);
            } else {
                System.out.println(bfs(startX, startY, endX, endY));
            }
        }
    }

    private static int bfs(int startX, int startY, int endX, int endY){
        Queue<twoPoint> queue = new LinkedList<>();
        queue.offer(new twoPoint(startX, startY));
        visited[startX][startY] = true;

        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                twoPoint now = queue.poll();

                for (int j = 0; j < 8; j++) {
                    dx = p[j].x + now.x;
                    dy = p[j].y + now.y;
                    if (dx == endX && dy == endY) return count;

                    if (0 <= dx && dx < I && 0 <= dy && dy < I && !visited[dx][dy]){
                        visited[dx][dy] = true;
                        queue.offer(new twoPoint(dx, dy));
                    }
                }
            }
            count++;
        }
        return count;
    }
}
