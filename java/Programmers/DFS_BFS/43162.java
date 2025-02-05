package Programmers.DFS_BFS;

import java.util.ArrayList;

public class network {

    
    class Solution {
        boolean[] visited;
        ArrayList<Integer>[] arr;
        
        public int solution(int n, int[][] computers) {
            int answer = 0;
            arr = new ArrayList[n];
            visited = new boolean[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < computers.length; i++) {
                for (int j = 0; j < computers[i].length; j++) {
                    if (i != j && computers[i][j] == 1) {
                        arr[i].add(j);
                        arr[j].add(i);
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    answer++;
                }
            }
            
            return answer;
        }
        public void dfs(int idx) {
            visited[idx] = true;
            
            for (int child : arr[idx]) {
                if (!visited[child]) {
                    dfs(child);
                }
            }
        }
        
    }

    /**
     * 다른 사람 풀이
     */
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!chk[i]) {
                dfs(computers, chk, i);
                answer++;
            }
        }
        return answer;
    }
    void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i);
            }
        }
    }
}


