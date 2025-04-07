package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1374 {
    static class Lecture {
        int id;
        int start;
        int end;

        public Lecture(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n + 1];

        for (int i = 1 ; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lectures, 1, n + 1, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (!pq.isEmpty() && pq.peek() <= lectures[i].start) {
                pq.poll();
            }

            pq.offer(lectures[i].end);
        }
        System.out.println(pq.size());
        
    }
}
