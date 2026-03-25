package BeakJoon_DFS_BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_7576 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Point> queue = new LinkedList<>();

        int[][] stated = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                stated[i][j] = Integer.parseInt(st.nextToken());
                if ((stated[i][j] == 1)){
                    queue.offer(new Point(i, j));
                }
            }
        }

        int dayCount = 0;
        int[] dX = {0, 0, -1, 1};
        int[] dY = {-1, 1, 0, 0};
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isChecked = false;

            for (int i = 0; i < size; i++) {
                Point now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nX = now.x + dX[j];
                    int nY = now.y + dY[j];
                    if ((0 <= nX && nX < M) && (0 <= nY && nY < N) && (stated[nX][nY] == 0)){
                        stated[nX][nY] = 1;
                        queue.offer(new Point(nX, nY));
                        isChecked = true;
                    }
                }
            }

            if (isChecked) {
                dayCount++;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (stated[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(dayCount);
    }
}
