package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine()); // 3  ~ 1,000,000
            StringTokenizer st = new StringTokenizer(br.readLine()); // 각 파일 크기 < 10,000

            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int i = 0; i < k; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            // 작은 것들부터 차례로 더하는 경우 최소가 될 수 없음
            // 임시 파일을 활용해야 할 것 같다
            // 언제 임시 파일을 생성할 것인가? 누구랑 더할 것인가?

            long total = 0;
            while (pq.size() > 1) {
                long value = pq.poll() + pq.poll();
                total += (value);
                pq.add(value);
            }
            System.out.println(total);
        }
    }
}