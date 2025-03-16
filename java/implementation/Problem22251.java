package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem22251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n층 1 ~ 10^k
        int k = Integer.parseInt(st.nextToken()); // k자리수 디스플레이 1 ~ 6
        int p = Integer.parseInt(st.nextToken()); // p개 반전 1 ~ 42
        int x = Integer.parseInt(st.nextToken()); // 현재 x층 1 ~ 10^k

        // 1 ~ n층 범위 내 변경 가능, 1 ~ p 변경
        // 0 ~ 9 를 특정 배열값으로?

        int[][] digits = {
            {1, 1, 1, 0, 1, 1, 1}, // 0
            {0, 0, 1, 0, 0, 0, 1}, // 1
            {0, 1, 1, 1, 1, 1, 0}, // 2
            {0, 1, 1, 1, 0, 1, 1}, // 3
            {1, 0, 1, 1, 0, 0, 1}, // 4
            {1, 1, 0, 1, 0, 1, 1}, // 5
            {1, 1, 0, 1, 1, 1, 1}, // 6
            {0, 1, 1, 0, 0, 0, 1}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 1, 1, 0, 1, 1}  // 9
        };

        // 숫자 간 변환에 필요한 반전 횟수수
        int[][] changes = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) continue;
                for (int l = 0; l < 7; l++) {
                    if (digits[i][l] != digits[j][l]) {
                        changes[i][j]++;
                    }
                }
            }
        }

        int[] currentFloor = new int[k];
        int temp = x;
        for (int i = k - 1; i >= 0; i--) {
            currentFloor[i] = temp % 10;
            temp /= 10;
        }

        // 1 ~ n까지 모든 층을 검사
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;

            int[] targetFloor = new int[k];
            temp = i;
            for (int j = k - 1; j >= 0; j--) {
                targetFloor[j] = temp % 10;
                temp /= 10;
            }

            int totalChanges = 0;
            for (int j = 0; j < k; j++) {
                totalChanges += changes[currentFloor[j]][targetFloor[j]];
            }

            if (totalChanges > 0 && totalChanges <= p) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
