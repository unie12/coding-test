package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11123 {
    static int t, h, w;
    static char[][] sheeps;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            sheeps = new char[h][w];
            visited = new boolean[h][w];

            for (int j = 0; j < h; j++) {
                sheeps[j] = br.readLine().toCharArray();
            }

            int count = 0;
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (!visited[j][k] && sheeps[j][k] == '#') {
                        dfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny] && sheeps[nx][ny] == '#') {
                dfs(nx, ny);
            }
        }
    }
}
