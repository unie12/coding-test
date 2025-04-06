package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n개의 물병
        int k = Integer.parseInt(st.nextToken()); // 한 번에 k개의 물병 옮길 수 있음

        // 2^n? n이 근접 2^n까지 몇 개가 필요한지?
        // k개는 어떤 영향? -> 2^n의 값을 줄일 수 있음

        if (Integer.bitCount(n) <= k) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        while (true) {
            n++;
            answer++;

            if (Integer.bitCount(n) <= k) {
                break;
            }
        }
        System.out.println(answer);
        
    }
}
