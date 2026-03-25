package BeakJoon_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_12891 {
    static int[] checkArray = new int[4];
    static int checkCount = 0;
    static int[] myArray = new int[4];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int total = 0;

        char[] A = new char[S];
        A = bf.readLine().toCharArray();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            myArray[i] = Integer.parseInt(st.nextToken());
            if (myArray[i] == 0) checkCount++;
            // 0이면 이미 checkCount 중 4개 중 0인 얘는 만족을 한 것이니까.
        }

        // 부분 배열을 확인하는 첫 번째 시도
        for (int i = 0; i < P; i++) {
            add(A[i]);
        }
        if (checkCount == 4) total++;
        
        // 슬라이딩 윈도우
        // 첫 번째 시도에서 나와서 P번째 있는 얘부터 S까지 한 칸씩 이동하면서 확인
        for (int i = P; i < S; i++) {
            int j = i - P;
            add(A[i]);
            remove(A[j]);
            if (checkCount == 4) total++;
        }
        System.out.println(total);
        bf.close();
    }

    /**
     * [예시]
     * ACA 중 2글자를 고를 때, 첫 시도 AC로 이미 total++이 됐을테니까,
     * CA가 나올 때 total++이 되려면 이미 지나 간 A를 ++ 했던 인덱스 숫자를 -- 해줘야한다.
     * 또한, 이미 지나갔으므로 배열에서 없애준다.
     */
    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (myArray[0] == checkArray[0]) checkCount--;
                checkArray[0]--;
                break;
            case 'C':
                if (myArray[1] == checkArray[1]) checkCount--;
                checkArray[1]--;
                break;
            case 'G':
                if (myArray[2] == checkArray[2]) checkCount--;
                checkArray[2]--;
                break;
            case 'T':
                if (myArray[3] == checkArray[3]) checkCount--;
                checkArray[3]--;
                break;
        }
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                checkArray[0]++;
                if (myArray[0] == checkArray[0]) checkCount++;
                break;
            case 'C':
                checkArray[1]++;
                if (myArray[1] == checkArray[1]) checkCount++;
                break;
            case 'G':
                checkArray[2]++;
                if (myArray[2] == checkArray[2]) checkCount++;
                break;
            case 'T':
                checkArray[3]++;
                if (myArray[3] == checkArray[3]) checkCount++;
                break;
        }
    }
}
