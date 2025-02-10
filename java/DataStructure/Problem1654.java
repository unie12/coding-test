package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long left = 1, right = arr[k-1];
        long answer = 0;

        while (left <= right) {
            long middle = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < k; i++) {
                count += (arr[i] / middle);
            }
            if (count >= n) {
                answer = Math.max(middle, answer);
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println(answer);
        
    }
}
