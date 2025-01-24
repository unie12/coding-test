package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] minDp = new int[3];
        int[] maxDp = new int[3];
        int[] arr = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            maxDp[i] = minDp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int prevMax0 = maxDp[0], prevMax2 = maxDp[2];
            int prevMin0 = minDp[0], prevMin2 = minDp[2];

            maxDp[0] = Math.max(maxDp[0], maxDp[1]) + arr[0];
            maxDp[2] = Math.max(maxDp[1], maxDp[2]) + arr[2];
            maxDp[1] = Math.max(Math.max(prevMax0, maxDp[1]), prevMax2) + arr[1];

            minDp[0] = Math.min(minDp[0], minDp[1]) + arr[0];
            minDp[2] = Math.min(minDp[1], minDp[2]) + arr[2];
            minDp[1] = Math.min(Math.min(prevMin0, minDp[1]), prevMin2) + arr[1];
        }

        int max = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int min = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);
        System.out.println(max + " " + min);

            
    }
}
