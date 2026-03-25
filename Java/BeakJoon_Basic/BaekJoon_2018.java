package BeakJoon_Basic;

import java.util.Scanner;

public class BaekJoon_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();
        int count = 1; // 자기 자신 경우의 수 포함
        int sum = 1;
        int startNum = 1;
        int endNum = 1;

        while(startNum != numCount) {
            if (sum == numCount){
                count++;
                endNum++;
                sum += endNum;
            } else if (sum > numCount) {
                startNum++;
                sum = startNum;
                endNum = startNum;
            } else if (sum < numCount) {
                endNum++;
                sum += endNum;
            }
        }
        System.out.println(count);
    }
}
