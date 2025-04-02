package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int[] weight = new int[26];

        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                weight[c - 'A'] += (int) Math.pow(10, len - i - 1);
            }
        }

        Arrays.sort(weight);

        int result = 0;
        int num = 9;

        for (int i = 25; i >= 0; i--) {
            if (weight[i] == 0) break;
            result += weight[i] * num--;
        }
        System.out.println(result);
    }
}
