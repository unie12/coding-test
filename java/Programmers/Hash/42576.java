package Programmers.Hash;

import java.util.Arrays;
import java.util.HashMap;

public class 42576 {
    
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> players = new HashMap<>();
            for (String name : participant) {
                players.put(name, players.getOrDefault(name, 0) + 1);
            }
            for (String name : completion) {
                players.put(name, players.get(name) - 1);
            }
            for (Map.Entry<String, Integer> entry : players.entrySet()) {
                if (entry.getValue() > 0) {
                    answer = entry.getKey();
                    break;
                }
            }
            return answer;
        }
    }
}
