package BeakJoon_Basic;


import java.util.Scanner;

public class BaekJoon_1475 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4 ,5 ,6 ,7,  8, 9};
        int[] countArr = new int[10];
        int[] statedArr = new int[10];
        int temp;

        String N;

        Scanner sc = new Scanner(System.in);
        N = sc.nextLine();


        for (int i = 0; i < N.length(); i++) {
            temp = N.charAt(i);
            statedArr[i] = temp - '0';
            System.out.println(statedArr[i]);
        }
    }
}
