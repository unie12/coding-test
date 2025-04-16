package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.DrbgParameters.Reseed;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];

            // 중앙값이 가장 큰 값으로? 그리고 양 옆을 점점 줄여나가는 식
            // 아니면 정렬한 다음에 중앙 인덱스 ~ 마지막 인덱스를 reverse하는 식
            
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int[] result = new int[n];
            int left = 0;
            int right = n - 1;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    result[left++] = arr[i];
                } else {
                    result[right--] = arr[i];
                }
            }

            int maxDiff = Math.abs(result[0] - result[n - 1]);
            for (int i = 1; i < n; i++) {
                maxDiff = Math.max(maxDiff, Math.abs(result[i] - result[i - 1]));
            }
            sb.append(maxDiff).append('\n');
        }
        System.out.println(sb);
    }
}
