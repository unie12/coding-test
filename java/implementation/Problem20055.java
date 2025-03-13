package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[2 * n];
        boolean[] robot = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while (true) {
            step++;
            // 1. 벨트 회전
            int temp = arr[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
            robot[n - 1] = false;

            // 로봇 회전
            for (int i = n - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[n - 1] = false;

            // 2. 로봇 이동
            for (int i = n - 2; i >= 0; i--) {
                if (robot[i] && !robot[i + 1] && arr[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    arr[i + 1]--;
                }
            }

            robot[n - 1] = false;

            if (arr[0] > 0) {
                robot[0] = true;
                arr[0]--;
            }

            int count = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (arr[i] == 0) {
                    count++;
                }
            }

            if (count >= k) {
                break;
            }

        }
        System.out.println(step);
    }
}
