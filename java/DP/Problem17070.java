package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem17070 {
    static int n, answer = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int direction) {
        if (x == n && y == n) {
            answer++;
            return;
        }

        // 가로
        if (direction != 1 && y + 1 <= n && arr[x][y+1] == 0) {
            dfs(x, y + 1, 0);
        }

        // 세로
        if (direction != 0 && x + 1 <= n && arr[x+1][y] == 0) {
            dfs(x + 1, y, 1);
        }

        // 대각선선
        if (x + 1 <= n && y + 1 <= n && arr[x + 1][y] == 0 && arr[x][y + 1] == 0 && arr[x+1][y+1] == 0) {
                dfs(x + 1, y + 1, 2);
        }
    }
}

// // 0 가로 1: 대각선 2: 세로
// dp[0][1][0] = 1;
// for (int i = 0; i < n; i++) {
//     for (int j = 2; j < n; j++) {
//         // 가로
//         if (arr[i][j] == 1) continue;
//         dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];

//         // 세로
//         if (i == 0) continue;
//         dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];

//         // 대각선
//         if (arr[i-1][j] == 1 || arr[i][j-1] == 1) continue;
//         dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
//     }
// }