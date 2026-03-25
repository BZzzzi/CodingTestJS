package BeakJoon_Basic;

import java.util.Scanner;

public class BaekJoon_1546_ver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int maxNum = 0;
        double numSum = 0;

        for (int i = 0; i < count; i++) {
            int temp = sc.nextInt();
            if (maxNum < temp){
                maxNum = temp;
            }
            numSum += temp;
        }

        double finalAvg = (((numSum/maxNum)*100)/count);
        System.out.println(finalAvg);
    }
}
