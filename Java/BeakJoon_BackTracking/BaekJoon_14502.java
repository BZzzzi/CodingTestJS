import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BaekJoon_14502 {
    static int N, M, safetyArea = 0;
    static int[][] map;
    static int[][] newMap;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BuildWall(0);
        System.out.println(safetyArea);
    }

    private static void BuildWall(int count) {
        if(count == 3) {
            // 얕은 복사로 인한 난관
            // 그러나.. 깊은 복사로 해결
            newMap = Stream.of(map)
                    .map(row -> Arrays.copyOf(row, row.length))
                    .toArray(int[][]::new);
            BFS();
            return;
        }

        for(int nx = 0; nx < N ;nx++) {
            for(int ny = 0; ny < M; ny++) {
                if(map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    BuildWall(count + 1);
                    map[nx][ny] = 0;
                }
            }
        }
    }

    private static void BFS() {
        int temp = 0;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 2){
                    queue.offer(new Point(i, j));
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        while (!queue.isEmpty()){
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int fx = now.x + dx[i];
                int fy = now.y + dy[i];
                if (0 <= fx && fx < N && 0 <= fy && fy < M && newMap[fx][fy] == 0) {
                    newMap[fx][fy] = 2;
                    queue.offer(new Point(fx, fy));
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 0){
                    temp++;
                }
            }
        }
        safetyArea = Math.max(temp, safetyArea);
    }
}
