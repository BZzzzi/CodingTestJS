package BeakJoon_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arraySort = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arraySort[i] = Integer.parseInt(st.nextToken());
        }

        int temp;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                temp = arraySort[j];
                if (temp > arraySort[j + 1]){
                    arraySort[j] =  arraySort[j + 1];
                    arraySort[j + 1] =  temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arraySort[i]);
        }
    }
}
