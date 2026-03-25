package BeakJoon_Basic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_1005 {
    static class Building {
        int vertex, time;

        public Building(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }
    }

    static int T, N, K;
    static List<List<Building>> list;
    static int[] order;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        while (T > 0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            order = new int[N + 1];
            st = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= N; i++) {
               order[i] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList<>(N + 1);
            for (int i = 1; i <= N ; i++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(new Building(b, 0));
            }



            T--;
        }
    }
}
