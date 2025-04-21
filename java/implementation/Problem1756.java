package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1756 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken()); // 1 ~ 300,000 오븐 깊이
        int n = Integer.parseInt(st.nextToken()); // 1 ~ 300,000 피자 반죽

        int[] oven = new int[d + 1];
        st = new StringTokenizer(br.readLine());
        // 오븐 최상단부터 입력
        for (int i = 1; i <= d; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= d; i++) {
            if (oven[i] > oven[i - 1]) {
                oven[i] = oven[i - 1];
            }
        }

        // 피자 크기
        st = new StringTokenizer(br.readLine());
        int depth = d;
        for (int i = 0; i < n; i++) {
            int pizza = Integer.parseInt(st.nextToken());

            while (depth > 0 && oven[depth] < pizza) {
                depth--;
            }

            if (depth > 0) {
                depth--;
            } else {
                depth = 0;
                break;
            }
        }

        System.out.println(depth == 0 ? 0 : depth + 1);

    }
}
