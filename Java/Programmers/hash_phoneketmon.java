package Programmers;

import java.util.HashSet;

public class hash_phoneketmon {
    public static void main(String[] args) {
        int nums[] = {3, 3, 3, 2, 2, 2, 4, 5, 3, 3};
        int sum = solution(nums);
        System.out.println(sum);
    }

    public static int solution(int[] nums){
        HashSet<Integer> sol = new HashSet<>();
        for (int num : nums){
            sol.add(num);
        }

        return Math.min(sol.size(), (nums.length/2));
    }

}
