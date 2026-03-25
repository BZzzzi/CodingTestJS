package BeakJoon_Basic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1330 {
    public static void main(String[] args) throws IOException {
        String result = "";

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        if (a > b) result = ">";
        else if (a < b) result = "<";
        else result = "==";

        System.out.println(result);
    }
}
