package BeakJoon_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T > 0){
            st = new StringTokenizer(bf.readLine());
            String input = st.nextToken();

            int totalCount = 0;
            Character[] inputChar = new Character[input.length()];
            boolean inputCheck;
            int count = 0;

            for (int i = 0; i < input.length(); i++) {
                inputChar[i] = input.charAt(i);
            }

            for (int i = 0; i < input.length(); i++) {
                if (inputChar[i].equals('O')){
                    count++;
                    totalCount += count;
                    inputCheck = true;
                } else {
                    inputCheck = false;
                }
                if (!inputCheck){
                    count = 0;
                }
            }

            System.out.println(totalCount);
            T--;
        }

    }
}
