package BeakJoon_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_16953_ver2 {
    static int A, B, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        while(true){
            if (B == A) break;
            if (B >= A && B % 2 == 0){
                B /= 2;
                count++;
            } else if (B >= A && B % 10  == 1){
                B /= 10;
                count++;

            } else {
                break;
            }
        }
        if (B != A) {
            count = -1;
            System.out.println(count);
        } else System.out.println(count + 1);
    }
}
