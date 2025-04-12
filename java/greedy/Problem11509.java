package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1 ~ 1,000,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrows = new int[1000001];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (arrows[height] > 0) {
                arrows[height]--;
                arrows[height - 1]++;
            } else {
                answer++;
                arrows[height - 1]++;
            }
        }
        System.out.println(answer);
    }
}
