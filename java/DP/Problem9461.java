package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9461 {
    static int n;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[5] = dp[4] = 2;
        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            System.out.println(dp[t]);
        }
        
    }
}

