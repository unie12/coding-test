package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] count = new int[26];
            for (char c : w.toCharArray()) {
                count[c - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int j = 0; j < 26; j++) {
                if (count[j] >= k) {
                    char target = (char) (j + 'a');
                    int targetCount = 0;

                    for (int left = 0, right = 0; right < w.length(); right++) {
                        if (w.charAt(right) == target) {
                            targetCount++;
                        }

                        while (targetCount >= k) {
                            if (w.charAt(left) == target) {
                                if (targetCount == k) {
                                    int windowSize = right - left + 1;
                                    min = Math.min(min, windowSize);
                                    max = Math.max(max, windowSize);
                                }
                                targetCount--;
                            }
                            left++;
                        }
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
