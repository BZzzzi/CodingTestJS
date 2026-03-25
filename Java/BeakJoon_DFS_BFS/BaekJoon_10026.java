    package BeakJoon_DFS_BFS;


    import java.awt.*;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.StringTokenizer;

    public class BaekJoon_10026 {
        static int N, count = 0, count2 = 0;
        static String[][] map;
        static boolean[][] visited;
        static Queue<Point> queue = new LinkedList<>();

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            map = new String[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String temp = bf.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = String.valueOf(temp.charAt(j));
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].equals("R") && !visited[i][j]) {
                        rBFS(i, j);
                        count++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].equals("G") && !visited[i][j]) {
                        gBFS(i, j);
                        count++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].equals("B")  && !visited[i][j]) {
                        bBFS(i, j);
                        count++;
                    }
                }
            }
            System.out.print(count);

            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].equals("G")) {
                        map[i][j] = "R";
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].equals("R")  && !visited[i][j]) {
                        rgBFS(i, j);
                        count2++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].equals("B")  && !visited[i][j]) {
                        bbBFS(i, j);
                        count2++;
                    }
                }
            }
            System.out.print(" " + count2);

        }

        private static void rBFS(int i, int j) {
            visited[i][j] = true;
            queue.offer(new Point(i, j));

            int[] nx = {0, 0, -1, 1};
            int[] ny = {-1, 1, 0, 0};
            while(!queue.isEmpty()){
                Point now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int dx = now.x + nx[k];
                    int dy = now.y + ny[k];
                    if (0 <= dx && dx < N && 0 <= dy && dy < N && map[dx][dy].equals("R") && !visited[dx][dy]){
                        visited[dx][dy] = true;
                        queue.offer(new Point(dx, dy));
                    }
                }
            }
        }

        private static void gBFS(int i, int j) {
            visited[i][j] = true;
            queue.offer(new Point(i, j));

            int[] nx = {0, 0, -1, 1};
            int[] ny = {-1, 1, 0, 0};
            while(!queue.isEmpty()){
                Point now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int dx = now.x + nx[k];
                    int dy = now.y + ny[k];
                    if (0 <= dx && dx < N && 0 <= dy && dy < N && map[dx][dy].equals("G") && !visited[dx][dy]){
                        visited[dx][dy] = true;
                        queue.offer(new Point(dx, dy));
                    }
                }
            }
        }

        private static void bBFS(int i, int j) {
            visited[i][j] = true;
            queue.offer(new Point(i, j));

            int[] nx = {0, 0, -1, 1};
            int[] ny = {-1, 1, 0, 0};
            while(!queue.isEmpty()){
                Point now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int dx = now.x + nx[k];
                    int dy = now.y + ny[k];
                    if (0 <= dx && dx < N && 0 <= dy && dy < N && map[dx][dy].equals("B") && !visited[dx][dy]){
                        visited[dx][dy] = true;
                        queue.offer(new Point(dx, dy));
                    }
                }
            }
        }

        private static void rgBFS(int i, int j) {
            visited[i][j] = true;
            queue.offer(new Point(i, j));

            int[] nx = {0, 0, -1, 1};
            int[] ny = {-1, 1, 0, 0};
            while(!queue.isEmpty()){
                Point now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int dx = now.x + nx[k];
                    int dy = now.y + ny[k];
                    if (0 <= dx && dx < N && 0 <= dy && dy < N && map[dx][dy].equals("R") && !visited[dx][dy]){
                        visited[dx][dy] = true;
                        queue.offer(new Point(dx, dy));
                    }
                }
            }
        }

        private static void bbBFS(int i, int j) {
            visited[i][j] = true;
            queue.offer(new Point(i, j));

            int[] nx = {0, 0, -1, 1};
            int[] ny = {-1, 1, 0, 0};
            while(!queue.isEmpty()){
                Point now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int dx = now.x + nx[k];
                    int dy = now.y + ny[k];
                    if (0 <= dx && dx < N && 0 <= dy && dy < N && map[dx][dy].equals("B") && !visited[dx][dy]){
                        visited[dx][dy] = true;
                        queue.offer(new Point(dx, dy));
                    }
                }
            }
        }
    }
