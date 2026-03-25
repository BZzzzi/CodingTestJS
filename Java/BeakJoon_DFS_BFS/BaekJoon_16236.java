package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_16236 {
    static class PriorityShark implements Comparable<PriorityShark>{
        int row, col, cost;

        public PriorityShark(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(PriorityShark other){
            if(this.cost == other.cost){
                if (this.row == other.row){
                    return this.col - other.col;
                }
                return this.row - other.row;
            }
            return this.cost - other.cost;
        }
    }

    static int N, sharkX, sharkY, distance = 0, babyShark = 2, sizeCount = 0;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9){
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true){
            PriorityShark nextFish = bfs();
            if (nextFish == null) break;

            sharkX = nextFish.row;
            sharkY = nextFish.col;
            distance += nextFish.cost;

            map[sharkX][sharkY] = 0;
            sizeCount++;
            if (sizeCount == babyShark){
                babyShark++;
                sizeCount = 0;
            }
        }
        System.out.println(distance);
    }

    private static PriorityShark bfs(){
        Queue<PriorityShark> queue = new LinkedList<>();
        PriorityQueue<PriorityShark> pq = new PriorityQueue<>();
        visited = new boolean[N][N];
        visited[sharkX][sharkY] = true;

        queue.offer(new PriorityShark(sharkX, sharkY, 0));

        int[] dX = {-1, 1, 0, 0};
        int[] dY = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            PriorityShark now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = dX[i] + now.row;
                int nY = dY[i] + now.col;

                if (nX < 0 || nX >= N || nY < 0 || nY >= N || visited[nX][nY] || map[nX][nY] > babyShark) continue;

                visited[nX][nY] = true;

                if (0 < map[nX][nY] && map[nX][nY] < babyShark){
                    pq.offer(new PriorityShark(nX, nY, now.cost + 1));
                }
                queue.offer(new PriorityShark(nX, nY, now.cost + 1));
            }
        }

        if (pq.isEmpty()) return null;
        return pq.poll();
    }
}
