package BeakJoon_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_3052 {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        boolean zeroCheck = false;
        int DUMMY_VALUE = -999999;
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int temp = a % 42;
            array[i] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if ((i != j) && (array[i] == array[j])){
                    array[i] = DUMMY_VALUE;
                    break;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (array[i] != DUMMY_VALUE && array[i] != 0) count++;
            if (array[i] == 0) zeroCheck = true;
        }

        if (zeroCheck) count++;
        System.out.println(count);
    }
}
