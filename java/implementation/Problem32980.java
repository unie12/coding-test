package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem32980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 ~ 10,000
        String[] trash = new String[n];

        for (int i = 0; i < n; i++) {
            trash[i] = br.readLine();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Character, Integer> costs = new HashMap<>();
        // P C V S G F O 1 ~ 10,000
        char[] tmp = {'P', 'C', 'V', 'S', 'G', 'F'};
        for (int i = 0; i < 6; i++) {
            costs.put(tmp[i], Integer.parseInt(st.nextToken()));
        }
        costs.put('O', Integer.parseInt(br.readLine()));


        long result = 0;
        for (int i = 0; i < n; i++) {
            boolean isHomogeneous = true;
            char firstChar = trash[i].charAt(0);

            for (int j = 1; j < trash[i].length(); j++) {
                if (firstChar != trash[i].charAt(j)) {
                    isHomogeneous = false;
                    break;
                }
            }

            int cost = costs.get('O');
            if (isHomogeneous) {
                if (costs.get(firstChar) < cost)
                    cost = costs.get(firstChar);
            }
            result += cost * trash[i].length();
        }
        System.out.println(result);
    }
}
