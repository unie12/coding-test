package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dpInc = new int[n];
        int[] dpDec = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dpInc[i] = 1;
            dpDec[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i ; j++) {
                if (arr[j] < arr[i]) {
                    dpInc[i] = Math.max(dpInc[i], dpInc[j] + 1);
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (arr[j] > arr[i]) {
        //             dpDec[i] = Math.max(dpDec[i], dpDec[j] + 1);
        //         }
        //     }
        // }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dpDec[i] = Math.max(dpDec[i], dpDec[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dpInc[i] + dpDec[i] - 1);
        }
        System.out.println(max);

    }
}
