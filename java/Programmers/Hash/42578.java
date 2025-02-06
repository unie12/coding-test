package Programmers.Hash;

public class 42578 {
    class Solution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> fashion = new HashMap<>();
            
            for(String[] cloth : clothes) {
                fashion.put(cloth[1], fashion.getOrDefault(cloth[1], 0) + 1);
            }
            
            int answer = 1;
            for(Integer count : fashion.values()) {
                answer *= (count + 1);
            }
            
            return answer - 1;
        }
    }
    
}
