package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12865 {
    static int n, k;
    static int[] weight;
    static int[] value;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        weight = new int[n + 1];
        value = new int[n + 1];
        dp = new Integer[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(n, k)); // 물품 수, 버틸 수 있는 무게
    }

    static int knapsack(int i, int w) {
        if (i == 0) return 0;

        if (dp[i][w] == null) {
            if (weight[i] > w) {
                dp[i][w] = knapsack(i - 1, w);
            } else {
                dp[i][w] = Math.max(knapsack(i - 1, w), knapsack(i - 1, w - weight[i]) + value[i]);
            }
        }
        return dp[i][w];
    }
}

// 공간복잡도 최적화 및 메모리 사용량 최적화
// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
        
//         int N = Integer.parseInt(st.nextToken());
//         int K = Integer.parseInt(st.nextToken());
        
//         int[][] dp = new int[N + 1][K + 1];
//         int[] W = new int[N + 1];
//         int[] V = new int[N + 1];
        
//         for (int i = 1; i <= N; i++) {
//             st = new StringTokenizer(br.readLine());
//             W[i] = Integer.parseInt(st.nextToken());
//             V[i] = Integer.parseInt(st.nextToken());
//         }
        
//         for (int i = 1; i <= N; i++) {
//             for (int w = 1; w <= K; w++) {
//                 if (W[i] > w) {
//                     dp[i][w] = dp[i - 1][w];
//                 } else {
//                     dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i]] + V[i]);
//                 }
//             }
//         }
        
//         System.out.println(dp[N][K]);
//     }
// }
