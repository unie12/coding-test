package Programmers.DFS_BFS;

public class 1844 {

    class Solution {
        static int[] dx = {1, 0, -1, 0};
        static int[] dy = {0, 1, 0, -1};
        static boolean[][] visited;
        static int n, m;
        
        public int solution(int[][] maps) {
            n = maps.length;
            m = maps[0].length;
            int answer = 0;
            visited = new boolean[n][m];
            
            answer = bfs(0, 0, maps);
            return answer;
        }
        
        public int bfs(int x, int y, int[][] maps) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x, y, 1});
            visited[x][y] = true;
            
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                
                if (current[0] == n-1 && current[1] == m-1) {
                    return current[2];
                }
                
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + current[0];
                    int ny = dy[i] + current[1];
                    
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, current[2] + 1});
                    }
                }
            }
            return -1;
        }
    }
}
