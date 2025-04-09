package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1083 {
    public static void main(String[] args) throws IOException {
        // 일단 가장 앞에 있는 정수들부터 비교 시작
        // 앞쪽에 있는 정수가 뒤쪽에 있는 정수보다 크다면 넘어가기
        // 교환 이후, 교환된 수의 앞쪽에 있는 수와 계속 비교

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n && s > 0; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n && j <= i + s; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            for (int j = maxIdx; j > i; j--) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                s--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
            // System.out.print(arr[i] + " ");
        }
        System.out.println(sb.toString());

    }
}
