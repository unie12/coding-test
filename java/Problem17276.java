import java.io.*;
import java.util.*;

public class Problem17276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (d < 0) d = 360 + d;
            int rotation = (d % 360) / 45;

            for (int j = 0; j < rotation; j++) {
                int[][] temp = new int[n][n];
                for (int k = 0; k < n; k++) {
                    System.arraycopy(arr[k], 0, temp[k], 0, n);
                }

                int mid = n/2;
                // for (int k = 0; k < n; k++) {
                //     arr[k][mid] = temp[k][k];
                //     arr[k][n-k-1] = temp[k][mid];
                //     arr[mid][n-k-1] = temp[n-k-1][n-k-1];
                //     arr[k][k] = temp[mid][k];
                // }
                for (int k = 0; k < n; k++) {
                    arr[k][mid] = temp[k][k];
                }
                // 가운데 열 -> 부 대각선
                for (int k = 0; k < n; k++) {
                    arr[k][n-k-1] = temp[k][mid];
                }
                // 부 대각선 -> 가운데 행
                for (int k = 0; k < n; k++) {
                    arr[mid][n-k-1] = temp[k][n-k-1];
                }
                // 가운데 행 -> 주 대각선
                for (int k = 0; k < n; k++) {
                    arr[k][k] = temp[mid][k];
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    bw.write(String.valueOf(arr[j][k]));
                    if (k < n-1) bw.write(" ");
                }
                bw.write("\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
