package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prbolem1189 {
    static int r, c, k;
    static char[][] map;
    static boolean[][] visited;
    static int result = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0 ; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'T') {
                    visited[i][j] = true;
                }
            }
        }

        visited[r-1][0] = true;
        dfs(r-1, 0, 1);
        System.out.println(result);
    }

    public static void dfs(int row, int col, int depth) {
        if (row == 0 && col == c-1 && depth == k) {
            result++;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = row + dx[k];
            int ny = col + dy[k];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1);
                visited[nx][ny] = false;
            }
        }

    }
    
}
