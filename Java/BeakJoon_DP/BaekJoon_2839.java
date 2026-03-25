package BeakJoon_DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] fiveArray = new int[N];

        int temp = 0;
        for (int i = 0; temp <= N; i++) {
            fiveArray[i] = temp;
            temp += 5;
        }

        int count = 0, tempThree = 0, minNum = Integer.MAX_VALUE;

        for (int i = 0; i < fiveArray.length; i++) {
            int tempFive = fiveArray[i];
            for (int j = 0; j < (N / 3); j++) {
                if (tempFive == N){
                    count = i + j;
                    if (minNum > count){
                        minNum = count;
                    }
                }
                tempFive += 3;
                tempThree += 3;
                if (tempThree == N){
                    count = j + 1;
                    if (minNum > count){
                        minNum = count;
                    }
                }
            }
        }

        if (count == 0)
            System.out.println(-1);
        else {
            System.out.println(minNum);
        }
    }
}
