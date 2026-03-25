package BeakJoon_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        int item[] = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(item);

        int startIndex = 0;
        int endIndex = N - 1;
        int count = 0;
        while(startIndex < endIndex) {
            int sum = (item[startIndex] + item[endIndex]);
            if (sum == M){
                startIndex++;
                endIndex--;
                count++;
                sum = 0;
            } else if (sum > M){
                endIndex--;
            } else if (sum < M){
                startIndex++;
            }
        }
        System.out.println(count);
    }
}
