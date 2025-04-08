package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 센서의 개수 1 ~ 10,000
        int k = Integer.parseInt(br.readLine()); // 기지국 개수 1 ~ 1,000
        int[] arr = new int[n];

        // 일단 입력 받고 정렬 시켜
        // 기지국 개수를 어떻게 나눠서 적용시킬까?
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] difference = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            difference[i] = arr[i + 1] - arr[i];
            // System.out.println("differ val: " + difference[i] + " arr[i+1]: " + arr[i+1] + " arr[i]: " + arr[i]);
        }

        Arrays.sort(difference);
        int result = 0;
        for (int i = 0; i < n - k; i++) {
            result += difference[i];
        }
        System.out.println(result);
    }
}
