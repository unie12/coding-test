package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18290 {
    static int n, m, k;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0, 0, 0);
        System.out.println(maxVal);
    }

    public static void dfs(int x, int y, int depth, int sum) {
        if (depth == k) {
            maxVal = Math.max(maxVal, sum);
            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = (i == x ? y : 0); j < m; j++) {
                if (!visited[i][j]) {
                    boolean valid = true;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny]) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        visited[i][j] = true;
                        dfs(i, j, depth + 1, sum + arr[i][j]);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }
}
