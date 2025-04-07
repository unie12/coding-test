package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 웅덩이 개수
        int l = Integer.parseInt(st.nextToken()); // 널빤지 길이

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int result = 0;
        int current = 0;
        // 그냥 웅덩이 나오면 널빤지 설치하면 되는거 아닌가? 다른 접근이 필요한가?
        for (int i = 0; i < n; i++) {
            if (arr[i][0] > arr[i][1]) continue;

            if (current > arr[i][0]) {
                arr[i][0] = current;
            }

            if (arr[i][0] >= arr[i][1]) continue;

            int length = arr[i][1] - arr[i][0];
            int count = (length + l - 1) / l;

            result += count;
            current = arr[i][0] + count * l;
        }
        System.out.println(result);
    }
}
