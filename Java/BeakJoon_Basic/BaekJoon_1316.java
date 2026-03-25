package BeakJoon_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        char[] checkString;
        int result = 0;

        while (true){
            if (N <= 0) break;

            StringTokenizer st = new StringTokenizer(bf.readLine());
            String temp = st.nextToken();
            checkString = new char[temp.length()];

            int checkCount = 0;
            boolean[] check = new boolean[temp.length()];

            for (int i = 0; i < temp.length(); i++) {
                checkString[i] = temp.charAt(i);
            }

            for (int i = 0; i < temp.length(); i++) {
                if (checkCount >= 2) break;
                checkCount = 0;
                check[i] = true;
                for (int j = i + 1; j < temp.length(); j++) {
                    if (checkString[i] == checkString[j]) {
                        check[j] = true;
                    } else {
                        check[j] = false;
                    }
                    if (check[j - 1] != check[j]) checkCount++;
                }
            }

            if (checkCount < 2) result++;
            N--;
        }

        System.out.println(result);
    }
}
