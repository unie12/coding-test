package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String token = br.readLine();
        
        int i = 1;
        int answer = 0, count = 0;

        while (i < m - 1) {
            if (token.charAt(i - 1) == 'I' && token.charAt(i) == 'O' && token.charAt(i + 1) == 'I') {
                count++;
                if (count == n) {
                    answer++;
                    count--;
                }
                i += 2;
            } else {
                count = 0;
                i++;
            }
        }
        System.out.println(answer);
    }
}
