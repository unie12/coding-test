package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10971 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static long result_min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        dfs(0, 0, 0);

        System.out.println(result_min);
    }

    public static void dfs(int start, int now, long cost) {
        if (allVisited()) {
            if (map[now][start] != 0) {
                result_min = Math.min(result_min, cost + map[now][start]);
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + map[now][i]);
                visited[i] = false;
            }
        }
    }

    public static boolean allVisited() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
