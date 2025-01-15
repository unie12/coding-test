package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16174 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0 ; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0, 0);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int jump = map[current[0]][current[1]];

            if (jump == -1) {
                System.out.println("HaruHaru");
                return;
            }

            int nx = current[0] + jump;
            if (nx >= 0 && nx < n && !visited[nx][current[1]]) {
                visited[nx][current[1]] = true;
                queue.offer(new int[]{nx, current[1]});
            }

            int ny = current[1] + jump;
            if (ny >= 0 && ny < n && !visited[current[0]][ny]) {
                visited[current[0]][ny] = true;
                queue.offer(new int[]{current[0], ny});
            }
        }
        System.out.println("Hing");
    }
}