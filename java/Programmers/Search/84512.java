package Programmers.Search;

public class 84512 {
    class Solution {
        public int solution(String word) {
            int[] weights = {781, 156, 31, 6, 1};
            String vowels = "AEIOU";
            int answer = word.length();
            
            for (int i = 0; i < word.length(); i++) {
                answer += weights[i] * vowels.indexOf(word.charAt(i));
            }
            return answer;
        }
    }

    class Solution {
        ArrayList<String> dictionary = new ArrayList<>();
        String[] vowels = {"A", "E", "I", "O", "U"};

        public int solution(String word) {
            dfs("");
            Collections.sort(dictionary);
            return dictionary.indexOf(word) + 1;
        }

        private void dfs(String str) {
            if (str.length > 5) return;
            if (!str.equals("")) dictionary.add(str);

            for (String vowel : vowels) {
                dfs(str + vowel);
            }
        }
    }
}
