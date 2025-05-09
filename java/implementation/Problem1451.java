package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        
        int[][] rectangles = new int[n + 1][m + 1];
        long[][] sum = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                rectangles[i][j] = line.charAt(j-1) - '0';
                sum[i][j] = rectangles[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        long maxProduct = 0;

        // 1. 세로 3등분
        for (int i = 1; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                long r1 = getSum(sum, 1, 1, n, i);
                long r2 = getSum(sum, 1, i + 1, n, j);
                long r3 = getSum(sum, 1, j + 1, n, m);
                maxProduct = Math.max(maxProduct, r1 * r2 * r3);
            }
        }

        // 2. 가로 3등분
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long r1 = getSum(sum, 1, 1, i, m);
                long r2 = getSum(sum, i + 1, 1, j, m);
                long r3 = getSum(sum, j + 1, 1, n, m);
                maxProduct = Math.max(maxProduct, r1 * r2 * r3);
            }
        }

        // 3. 왼쪽 세로 하나, 오른쪽 가로 둘
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long r1 = getSum(sum, 1, 1, n, i);
                long r2 = getSum(sum, 1, i + 1, j, m);
                long r3 = getSum(sum, j + 1, i + 1, n, m);
                maxProduct = Math.max(maxProduct, r1 * r2 * r3);
            }
        }

        // 4. 오른쪽 세로 하나, 왼쪽 가로 둘
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long r1 = getSum(sum, 1, 1, j, i);
                long r2 = getSum(sum, j + 1, 1, n, i);
                long r3 = getSum(sum, 1, i + 1, n, m);
                maxProduct = Math.max(maxProduct, r1 * r2 * r3);
            }
        }

        // 5. 위쪽 가로 하나, 아래쪽 세로 둘
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long r1 = getSum(sum, 1, 1, i, m);
                long r2 = getSum(sum, i + 1, 1, n, j);
                long r3 = getSum(sum, i + 1, j + 1, n, m);
                maxProduct = Math.max(maxProduct, r1 * r2 * r3);
            }
        }

        // 6. 아래쪽 가로 하나, 위쪽 세로 둘둘
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long r1 = getSum(sum, 1, 1, i, j);
                long r2 = getSum(sum, 1, j + 1, i, m);
                long r3 = getSum(sum, i + 1, 1, n, m);
                maxProduct = Math.max(maxProduct, r1 * r2 * r3);
            }
        }

        System.out.println(maxProduct);
    }



    private static long getSum(long[][] sum, int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
    }
}