package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1041 {
    public static void main(String[] args) throws IOException {
        // 진짜 감도 안잡힘..
        // 주사위가 접히는 방식도 생각해야 하고 어떤 숫자를 어디에 배치해야 하고
        // 각 주사위를 어디에 배치야하지?
        // 5면을 보여주기 때문에 보여주는 면이 큰 수여야 하는데
        // 3면 노출 (위쪽 4가지 꼭짓점)
        // 2면 노출 (모서리 + 아래쪽 4가지 꼭짓점)
        // 1면 노출 (꼭짓점/모서리 제외 나머지)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];


        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            int sum = 0;
            int max = 0;ㅉ
            for (int num : arr) {
                sum += num;
                max = Math.max(max, num);
            }
            System.out.println(sum - max);
            return;
        }

        // 주사위 면 중 최솟값 -> 1면 노출
        int min1 = Integer.MAX_VALUE;
        for (int num : arr) {
            min1 = Math.min(min1, num);
        }

        // 마주보지 않는 두면의 합 중 최솟값 -> 2면 노출
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j != 5) {
                    min2 = Math.min(min2, arr[i] + arr[j]);
                }
            }
        }

        // 마주보는 쌍의 최솟값 합 -> 3면 노출
        int min3  = Math.min(arr[0], arr[5]) 
                + Math.min(arr[1], arr[4])
                + Math.min(arr[2], arr[3]);

        long term3 = 4L * min3; // 3면 노출출
        long term2 = (8L * n - 12) * min2; // 2면 노출
        long term1 = (5L * n * n - 16L * n + 12) * min1; // 1면 노출
        long result = term1 + term2 + term3;
        System.out.println(result);
    }
}