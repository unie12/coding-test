package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2667 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, 0, -1 , 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n  = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    results.add(dfs(i, j));
                    // int result = dfs(i, j, 0);
                    // sb.append(result).append("\n");
                }
            }
        }
        Collections.sort(results);
        System.out.println(results.size());
        for (int result : results) {
            System.out.println(result);
        }
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[nx][ny] == 1) {
                count += dfs(nx, ny);
            }
        }
        System.out.println("count val: " + count);
        return count;
    }
}
