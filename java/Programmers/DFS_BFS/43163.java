package Programmers.DFS_BFS;

public class 43163 {
    
    class Solution {
        public int solution(String begin, String target, String[] words) {
            boolean contains = false;
            
            for (String word : words) {
                if (word.equals(word)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) return 0;
            return bfs(begin, target, words);
        }
        
        public int bfs(String begin, String target, String[] words) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(begin, 0));
            boolean[] visited = new boolean[words.length];
            
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                
                if (current.word.equals(target)) {
                    return current.count;
                }
                for (int i = 0; i < words.length; i++) {
                    if (!visited[i] && canTransform(current.word, words[i])) {
                        visited[i] = true;
                        queue.offer(new Node(words[i], current.count + 1));
                    }
                }
            }
            return 0;
        }
        
        private boolean canTransform(String curWord, String nextWord) {
            int diff = 0;
            for (int i = 0; i < curWord.length(); i++) {
                if (curWord.charAt(i) != nextWord.charAt(i)) diff++;
                if (diff > 1) return false;
            }
            return true;
        }
        
        class Node {
            String word;
            int count;
            
            Node(String word, int count) {
                this.word = word;
                this.count = count;
            }
        }
    }
}
