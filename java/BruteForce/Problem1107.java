package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 0 ~ 500,000
        int m = Integer.parseInt(br.readLine()); // 0 ~ 10

        boolean[] broken = new boolean[10];

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int minCount = Math.abs(n - 100);

        for (int i = 0; i <= 1000000; i++) {
            String channel = String.valueOf(i);
            boolean isPossible = true;

            for (int j = 0; j < channel.length(); j++) {
                if (broken[channel.charAt(j) - '0']) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                int count = channel.length() + Math.abs(n - i);
                minCount = Math.min(count, minCount);

            }
        }

        System.out.println(minCount);
    }
}
