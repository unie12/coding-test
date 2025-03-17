package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// public class Problem2631 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int n = Integer.parseInt(br.readLine());
//         int[] arr = new int[n + 1];
//         int[] dp = new int[n + 1];

//         for (int i = 1; i <= n; i++) {
//             arr[i] = Integer.parseInt(br.readLine());
//         }

//         int maxLength = 0;
//         for (int i = 1; i <= n; i++) {
//             dp[i] = 1; // 자기 자신 포함 최장 수열
//             for (int j = 1; j < i; j++) {
//                 // 이전 수열과 비교
//                 if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
//                     dp[i] = dp[j] + 1;
//                 }
//             }
//             maxLength = Math.max(maxLength, dp[i]);
//         }
//         System.out.println(n - maxLength);
//     }
// }


public class Problem2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] lis = new int[n + 1];
        int length = 0;

        for (int i = 1; i<= n; i++) {
            int pos = binarySearch(lis, 1, length, arr[i]);
            lis[pos] = arr[i];

            if (pos > length) {
                length = pos;
            }
        }
        System.out.println(n - length);
    }

    private static int binarySearch(int[] lis, int start, int end, int target) {
        int left = start;
        int right = end;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (lis[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}