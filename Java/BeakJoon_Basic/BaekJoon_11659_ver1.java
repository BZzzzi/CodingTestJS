package BeakJoon_Basic;

import java.util.Scanner;

public class BaekJoon_11659_ver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int oneCount = sc.nextInt();
        int twoCount = sc.nextInt();

        long[] s = new long[oneCount + 1];
        for (int i = 1; i <= oneCount; i++) {
            s[i] = s[i-1] + sc.nextInt();
        }

        for (int i = 0; i < twoCount; i++) {
            int oddTemp = sc.nextInt();
            int evenTemp = sc.nextInt();
            System.out.println(s[evenTemp] - s[oddTemp - 1]);
        }
    }
}

