package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Problem2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] counting = new int[8001];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            counting[arr[i] + 4000]++;
        }

        Arrays.sort(arr);

        sb.append(Math.round((double)sum / n)).append('\n');
        sb.append(arr[n/2]).append('\n');

        int maxCount = 0;
        int mode = 0;
        boolean isSecond = false;
        for (int i = 0; i < counting.length; i++) {
            if (counting[i] > maxCount) {
                maxCount = counting[i];
                mode = i - 4000;
                isSecond = false;
            } else if (counting[i] == maxCount && !isSecond) {
                mode = i - 4000;
                isSecond = true;
            }
        }
        sb.append(mode).append('\n');
        sb.append(arr[n-1] - arr[0]);
        System.out.println(sb);;
    }
}