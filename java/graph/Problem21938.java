package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem21938 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, t;
    static int[][] display;
    static boolean[][] visited;
    static int[][] newDisplay;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());   
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        display = new int[n][3*m];
        newDisplay = new int[n][3*m];
        visited = new boolean[n][3*m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3*m; j++) {
                int rgb = Integer.parseInt(st.nextToken());
                display[i][j] = rgb;
            }
        }

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = display[i][j*3] + display[i][j*3+1] + display[i][j*3+2];
                int avg = sum / 3;
                newDisplay[i][j] = avg >= t ? 255 : 0;
            }
        }

        int count = 0;
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && newDisplay[i][j] == 255) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && newDisplay[nx][ny] == 255) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
}
