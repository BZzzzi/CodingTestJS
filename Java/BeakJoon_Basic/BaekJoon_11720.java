package BeakJoon_Basic;

import java.util.Scanner;

public class BaekJoon_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int numSum = 0;

        sc.nextLine(); // 입력 버퍼 비우기

        String numArray = sc.nextLine();
        char[] numToChar = numArray.toCharArray();
        for (int i = 0; i < num; i++) {
            numSum += (numToChar[i] - '0');
        }
        System.out.println(numSum);
    }
}
