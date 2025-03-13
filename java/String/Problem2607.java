package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String first = br.readLine();
        int[] firstCount = new int[26];

        for (int i = 0; i < first.length(); i++) {
            firstCount[first.charAt(i) - 'A']++;
        }

        int result = 0;
        for (int i = 1; i < n; i++) {
            String word = br.readLine();

            int[] wordCount = new int[26];
            for (int j = 0; j < word.length(); j++) {
                wordCount[word.charAt(j) - 'A']++;
            }

            int diff = 0;
            int firstSum = 0;
            int wordSum = 0;

            for (int j = 0; j < 26; j++) {
                diff += Math.abs(firstCount[j] - wordCount[j]);
                firstSum += firstCount[j];
                wordSum += wordCount[j];
            }

            if (diff <= 2 && Math.abs(firstSum - wordSum) <= 1) {
                result++;
            }
        }
        System.out.println(result);
    }
}
