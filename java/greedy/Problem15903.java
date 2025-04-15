package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 2 ~ 1,000
        int m = Integer.parseInt(st.nextToken());  // 0 ~ 15 * n
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i <  m; i++) {
            long first = pq.poll();
            long second = pq.poll();
            pq.offer(first + second);
            pq.offer(first + second);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += pq.poll();
        }
        System.out.println(result);
        
    }
}
