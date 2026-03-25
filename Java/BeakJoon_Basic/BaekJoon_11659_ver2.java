package BeakJoon_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_11659_ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int oneCount = Integer.parseInt(st.nextToken());
        int twoCount = Integer.parseInt(st.nextToken());

        long[] s = new long[oneCount + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= oneCount; i++) {
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < twoCount; i++) {
            st = new StringTokenizer(br.readLine());
            int oddTemp = Integer.parseInt(st.nextToken());
            int evenTemp = Integer.parseInt(st.nextToken());
            System.out.println(s[evenTemp] - s[oddTemp - 1]);
        }
    }
}

