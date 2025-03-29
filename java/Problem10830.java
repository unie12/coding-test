import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = powMatrix(arr, b);
        printMatrix(result);
    }

    public static int[][] powMatrix(int[][] m, long exp) {
        int n = m.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) result[i][i] = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = multiplyMatrix(result, m);
            }
            m = multiplyMatrix(m, m);
            exp /= 2;
        }
        return result;
    }

    public static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                result[i][j] %= 1000;
            }
        }
        return result;
    }

    public static void printMatrix(int[][] m) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : m) {
            for (int num : row) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}