package BeakJoon_Basic;

import java.util.Scanner;

public class BaekJoon_1546_ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] score = new int[count];
        double numSum = 0;

        for (int i = 0; i < count; i++) {
            score[i] = sc.nextInt();
            numSum += score[i];
        }

        int maxNum = findMax(score);
        double finalAvg = (((numSum/maxNum)*100)/count);
        System.out.println(finalAvg);
    }

    public static int findMax(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}
