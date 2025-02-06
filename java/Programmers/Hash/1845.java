package Programmers.Hash;

import java.util.HashMap;

public class 1845 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            HashSet<Integer> pokemon = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                pokemon.add(nums[i]);
            }
            if (pokemon.size() > nums.length / 2) {
                answer = nums.length / 2;
            } else {
                answer = pokemon.size();
            }
            return answer;
        }
    }
}
