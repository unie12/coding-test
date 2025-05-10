package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem17140 {
    static int[][] arr = new int[101][101];
    static int r, c, k;
    static int result = 0;
    static int row = 3, col = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // 1 ~ 100
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // A[r][c]의 값이 k가 되기 위한 최소 시간

        // R 연산: A의 모든 행에 대해 정렬. 행의 개수 >= 열의 개수인 경우 진행
        // C 연산: A의 모든 열에 대해 정렬. 행의 개수 < 열의 개수 적용
        // 정렬: 수의 등장 횟수가 커지는 순, 수가 커지는 순으로 정렬 후 A에 다시 넣음
        // [수, 등장 횟수] -> 행, 열의 크기가 커진다면 0으로 채워놓고 0은 고려 x

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 어떻게 r, c의 크기에 맞춰 배열을 재할당할까??
        while (true) {
            if (arr[r][c] == k) {
                System.out.println(result);
                return;
            }

            if (result > 100) {
                System.out.println(-1);
                return;
            }

            result++;

            if (row >= col) {
                simulationRow();
            } else {
                simulationCol();
            }
        }
    }

    static void simulationRow() {
        int maxCOl = 0;
        for (int i = 1; i <= row; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int j = 1; j <= col; j++) {
                if (arr[i][j] == 0) continue;
                countMap.put(arr[i][j], countMap.getOrDefault(arr[i][j], 0) + 1);
            }

            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }

            Collections.sort(list, (a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });

            for (int j = 1; j <= col; j++) {
                arr[i][j] = 0;
            }

            int idx = 1;
            for (int[] pair : list) {
                if (idx > 100) break;
                arr[i][idx++] = pair[0];
                arr[i][idx++] = pair[1];
            }

            maxCOl = Math.max(maxCOl, Math.min(idx - 1, 100));
        }
        col = maxCOl;
    }

    static void simulationCol() {
        int maxRow = 0;

        for (int i = 1; i <= col; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 1; j <= row; j++) {
                if (arr[j][i] == 0) continue;
                countMap.put(arr[j][i], countMap.getOrDefault(arr[j][i], 0) + 1);
            }

            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }

            Collections.sort(list, (a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });

            for (int j = 1; j <= row; j++) {
                arr[j][i] = 0;
            }

            int idx = 1;
            for (int[] pair : list) {
                if (idx > 100) break;
                arr[idx++][i] = pair[0];
                arr[idx++][i] = pair[1];
            }

            maxRow = Math.max(maxRow, Math.min(idx - 1, 100));
        }

        row = maxRow;
    }
}
