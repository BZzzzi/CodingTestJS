package BeakJoon_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2920 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] array = new int[8];
        boolean check1 = true;
        boolean check2 = true;

        for (int i = 0; i < 8; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= 8; i++) {
            if(array[i-1] != i){
                check1 = false;
                break;
            }
        }

        for (int i = 8; i >= 1; i--) {
            if(array[array.length - i] != i){
                check2 = false;
                break;
            }
        }

        if (check1){
            System.out.println("ascending");
        }
        if (check2){
            System.out.println("descending");
        }
        else if (!check1 && !check2){
            System.out.println("mixed");
        }
    }
}
