package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전 수: 1 ~ 100
        int k = Integer.parseInt(st.nextToken()); // 가치의 합: 1 ~ 10,000
        int[] coins = new int[n];
        int[] dp = new int[k + 1];

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        // 동전의 가치는 1 ~ 100,000 + 가치가 같은 동전 여러 개 가능
        // 근데 어치피 k가 10,000까지인데 왜 동전의 가치가 이렇게 크지? 동인할 동전이 의미가 있나?
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }
}
