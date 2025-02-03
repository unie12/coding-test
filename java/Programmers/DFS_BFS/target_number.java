package Programmers.DFS_BFS;

public class target_number {
    class Solution {
        public int solution(int[] numbers, int target) {
            int answer = 0;
            answer = dfs(numbers, 0, 0, target);
            return answer;
        }
        
        public int dfs(int[] numbers, int sum, int idx, int target) {
            if (numbers.length == idx) {
                if (sum == target) {
                    return 1;
                }
                return 0;
            }
            return dfs(numbers, sum + numbers[idx], idx + 1, target) + dfs(numbers, sum - numbers[idx], idx + 1, target);
            
        }
    }
}
