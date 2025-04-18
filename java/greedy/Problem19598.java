package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem19598 {
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting other) {
            if (this.start == other.start)
                return this.end - other.end;
            
            return this.start - other.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }
        Arrays.sort(meetings);
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (Meeting meeting : meetings) {
            if (!rooms.isEmpty() && rooms.peek() <= meeting.start) {
                rooms.poll();
            }

            rooms.add(meeting.end);
        }
        System.out.println(rooms.size());
    }
}
