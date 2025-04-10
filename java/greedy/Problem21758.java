package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 3 ~ 100,000
        StringTokenizer st = new StringTokenizer(br.readLine()); // 꿀 양 1 ~ 10,000
        int[] honey = new int[n + 1];
        long[] prefixSum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + honey[i];
        }

        // 끝나는 지점이 큰 수면 좋을 듯, 그냥 무조건 양 끝이 베스트 아닌가? 양 끝이 아닌데 좋을 수가 있나?
        // 양 끝 수보다 가운데 지점의 값이 크면? 근데 가운데 쪽 값이 크다는 걸 어떻게 계산하지?
        // n이 3일 때만 가운데를 고려하며 되지 않나?
        // 벌 위치는 큰 수를 많이 지나는...?
        // 한 마리는 무조건 양쪽 끝 중 하나인게 좋을까?
        // 벌은 맨 왼쪽 or 오른쪽에 배치하고 해당 벌 값이 다음 수보다 크면 해당 벌 위치 옮기기..
        long result = 0;

        // 1. 꿀통이 오른쪽 끝, 벌들은 다른 위치
        for (int bee2 = 2; bee2 < n; bee2++) {
            long bee1Collected = prefixSum[n] - prefixSum[1] - honey[bee2];
            long bee2Collected = prefixSum[n] - prefixSum[bee2];
            result = Math.max(result, bee1Collected + bee2Collected);
        }
        // 2. 꿀통 왼쪽 끝, 벌들 다른 위치
        for (int bee1 = 2; bee1 < n; bee1++) {
            long bee1Collected = prefixSum[bee1 - 1];
            long bee2Collected = prefixSum[n - 1] - honey[bee1];
            result = Math.max(result, bee1Collected + bee2Collected);
        }
        // 3. 꿀통 중앙, 벌들 양쪽 끝
        for (int hive = 2; hive < n; hive++) {
            long bee1Collected = prefixSum[hive] - prefixSum[1];
            long bee2Collected = prefixSum[n - 1] - prefixSum[hive - 1];
            result = Math.max(result, bee1Collected + bee2Collected);
        }
        System.out.println(result);

    }
}