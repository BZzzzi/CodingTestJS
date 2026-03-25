package BeakJoon_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_16953 {
    static long A, B;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

//        int temp = Integer.parseInt(A);
//        String stemp = B + 1;
//        System.out.println(temp + "," + stemp);
//        int itemp = Integer.parseInt(stemp);
//        System.out.println(temp + "," + itemp);

        System.out.println(Dijkstrapq(A, B));
    }

    private static long Dijkstrapq(long start, long end){
        Queue<Long[]> queue = new LinkedList<>();
        queue.offer(new Long[] {start, 0L});
        // 해쉬 함수가 굴러갔던 이유는,, 10억까지 연산을 감당하는 로직이 아니기 때문
        // 원래는 키 값을 찾는 연산 자체가 무겁고 오래 걸림
        HashMap<Long, Long> visited = new HashMap<>();
        visited.put(start, 1L);

        while(!queue.isEmpty()){
            Long[] now = queue.poll();
            long count = now[1];

            if(now[0] == end) return count + 1L;

            if (now[0] * 2L  <= 1000000000 && (visited.get(now[0] * 2L) == null)) {
                queue.offer(new Long[] {(now[0] * 2L), count + 1L});
                visited.put((now[0] * 2L), 1L);
            }

            String strNow = now[0] + "1";
            long reIntNow = Long.parseLong(strNow);
            if (reIntNow <= 1000000000 && (visited.get(reIntNow) == null)) {
                queue.offer(new Long[] {reIntNow, count + 1L});
                visited.put(reIntNow, 1L);
            }
        }
        return -1L;
    }
}
