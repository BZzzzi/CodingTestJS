package BeakJoon_Brute_Force;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_2798_ver1 {
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
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        findBestSum(0, 0, 0);
        System.out.println(result);

    }

    private static void findBestSum(int depth, int start, int sum) {
        if (depth == 3) {
            // 4. 3 3 18일 때 if문을 돌고
            if (sum <= M) {
                result = Math.max(result, sum);
                // 5. result 값이 18로 갱신된다.
                // 10. result 값이 19로 갱신된다.
            }
            return;
            // 6. 함수가 종료되면 이전 호출로 돌아간다.
            // 11. 함수가 종료되면 이전 호출로 돌아간다.
        }
        for (int i = start; i < N; i++) {
            findBestSum(depth + 1, i + 1, sum + arr[i]);
            if (result == M) return;  // 최적의 값(21)을 찾으면 종료
            // 1. 1 1 5 호출

            // 2. 2 2 11 호출
            // 7. 이전 호출로 돌아옴
            // 8. 반복문 재개 i = 3
            // 9. 3 4 19 호출
            // 12. 이전 호출로 돌아옴
            // 13. 반복문 재개 i = 4
            // 14. 3 5 20 호출
            // 15. 반복

            // 3. 3 3 18 호출
        }
    }
}
