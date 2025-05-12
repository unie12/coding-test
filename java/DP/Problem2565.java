package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전기줄 1 ~ 100
        int[][] wires = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wires, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (wires[j][1] < wires[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("dp[" + i + "] : " + dp[i]);
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(n - maxLength);

    }
}