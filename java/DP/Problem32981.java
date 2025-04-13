package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem32981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine()); // 1 ~ 100,000
        int[] questions = new int[q];
        int max = 0;
        
        for (int i = 0; i < q; i++) {
            questions[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, questions[i]);

        }
        long[] dp = new long[max + 1];
        dp[1] = 5;
        dp[2] = 20;
        for (int i = 3; i <= max; i++) {
            dp[i] = (dp[i - 1] * 5) % 1000000007;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(dp[questions[i]]).append("\n");
        }
        System.out.println(sb);

    }
}