package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2579 {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int stair = Integer.parseInt(br.readLine());
            arr[i] = stair;
        }
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        if (n >= 3) {
            dp[3] = Math.max(arr[1], arr[2]) + arr[3];
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }

        System.out.println(dp[n]);
        
    }
}
