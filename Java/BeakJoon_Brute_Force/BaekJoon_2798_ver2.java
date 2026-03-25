package BeakJoon_Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_2798_ver2 {
    static int N, M, result = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int result = 0;
        int temp;
        for (int i = 0; i < N; i++) {
            int start = i + 1;
            int end = N - 1;
            while (start < end) {
                temp = arr[i] + arr[start] + arr[end];
                if (temp <= M) {
                    result = Math.max(result, temp);
                    start++;
                } else end--;
            }
        }
        System.out.println(result);
    }
}
