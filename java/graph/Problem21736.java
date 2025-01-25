package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem21736 {
    static char[][] campus;
    static boolean[][] visited;
    static int n, m;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];
        visited = new boolean[n][m];

        int currentX = -1, currentY = -1;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            campus[i] = line.toCharArray();
            int idx = line.indexOf('I');
            if (idx != -1) {
                currentX = i;
                currentY = idx;
            }
        }

        int friends = bfs(currentX, currentY);
        System.out.println(friends == 0 ? "TT" : friends);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && campus[nx][ny] != 'X' && !visited[nx][ny]) {
                    if (campus[nx][ny] == 'P') {
                        count++;
                    }
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return count;
    }
}
