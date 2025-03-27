package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem18428 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static int n;
    static ArrayList<int[]> teachers = new ArrayList<>();
    static boolean success = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 3 ~ 6
        board = new char[n][n];

        // T: 5 이하, S: 30 이하, 항상 빈 칸의 개수는 3개 이상
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = st.nextToken().charAt(0);
                if (board[i][j] == 'T') {
                    teachers.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0);
        System.out.println(success ? "YES" : "NO");

        // 1. 만약 T와 S가 붙어 있는 경우가 존재한다면 무조건 NO
        // 2. 오직 장애물 3개만 설치 가능
        // 3. 이외의 상황은 어떻게 판단하지?
    }

    static void dfs(int count, int start) {
        if (count == 3) {
            if (check()) {
                success = true;
            }
            return;
        }

        for (int i = start; i < n * n; i++) {
            int x = i / n;
            int y = i % n;

            if (board[x][y] == 'X') {
                board[x][y] = 'O';
                dfs(count + 1, i + 1);
                board[x][y] = 'X';
            }
        }
    }

    static boolean check() {
        for (int[] teacher : teachers) {
            int x = teacher[0];
            int y = teacher[1];

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                    if (board[nx][ny] == 'O') break;
                    if (board[nx][ny] == 'S') return false;
                }
            }
        }
        return true;
    }
}
