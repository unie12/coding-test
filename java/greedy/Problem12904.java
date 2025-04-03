package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem12904 {
    static String s, t;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        dfs(t);
        System.out.println(answer);
    }

    public static void dfs(String text) {
        if (text.length() == s.length()) {
            if (text.equals(s)) {
                answer = 1;
            }
            return;
        }

        if (text.endsWith("A")) {
            dfs(text.substring(0, text.length() - 1));
        }

        if (text.endsWith("B")) {
            StringBuilder sb = new StringBuilder(text.substring(0, text.length() - 1));
            dfs(sb.reverse().toString());
        }

    }
}
