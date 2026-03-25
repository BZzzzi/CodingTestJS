package BeakJoon_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2475 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int temp = 0;
        int signNum = 0;

        for (int i = 0; i < 5; i++) {
            signNum = Integer.parseInt(st.nextToken());
            temp += (signNum * signNum);
        }

        temp %= 10;
        System.out.println(temp);
    }
}
