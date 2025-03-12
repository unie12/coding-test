package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];
        dp[0] = 1;

        for (int i = 1; i <= 10000; i++) {
            dp[i] += dp[i-1];
        }

        for (int i = 2; i <= 10000; i++) {
            dp[i] += dp[i-2];
        }

        for (int i = 3; i <= 10000; i++) {
            dp[i] += dp[i-3];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
