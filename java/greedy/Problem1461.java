package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 책의 개수
        int m = Integer.parseInt(st.nextToken()); // 한 번에 들 수 있는 책의 개수
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int book = Integer.parseInt(st.nextToken());
            if (book > 0) positive.add(book);
            else negative.add(-book);
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative, Collections.reverseOrder());

        int maxDistance = 0;
        if (positive.isEmpty()) maxDistance = negative.get(0);
        else if (negative.isEmpty()) maxDistance = positive.get(0);
        else maxDistance = Math.max(positive.get(0), negative.get(0));

        for (int i = 0; i < positive.size(); i += m) {
            result += 2 * positive.get(i);
        }

        for (int i = 0; i < negative.size(); i += m) {
            result += 2 * negative.get(i);
        }

        System.out.println(result - maxDistance);
    }
}