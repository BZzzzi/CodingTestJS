package Programmers;

import java.util.Arrays;
import java.util.HashMap;

public class hash_fail_to_finish_ver1 {
    public static void main(String[] args) {
        String participant[] = {"aa", "cc", "bb"};
        String completion[] = {"aa", "bb"};
        String solution = solution(participant, completion);

    }

    public static String solution(String[] participant, String[] completion) {
        // sort 정렬을 하고, loop로 서로 비교해서 없는거 찾기
        // participant 마지막 선수 예외 처리
        Arrays.sort(participant);

        System.out.println(Arrays.toString(participant));
        return "aa";

        }
    }

