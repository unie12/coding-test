package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1987 {
    static int r, c;
    static char[][] board;
    static boolean[][] visited;
    static boolean[] alphabet;
    static int maxCount = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        visited = new boolean[r][c];
        alphabet = new boolean[26];

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visited[0][0] = true;
        alphabet[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(maxCount);
    }

    static void dfs(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            int index = board[nx][ny] - 'A';
            if (visited[nx][ny] || alphabet[index]) continue;

            visited[nx][ny] = true;
            alphabet[index] = true;
            dfs(nx, ny, count + 1);
            visited[nx][ny] = false;
            alphabet[index] = false;
        }
    }
}