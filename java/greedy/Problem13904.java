package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem13904 {
    static class Assignment implements Comparable<Assignment> {
        int deadline;
        int score;

        public Assignment(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }

        @Override
        public int compareTo(Assignment other) {
            return other.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1 ~ 1000
        Assignment[] assignments = new Assignment[n];
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 1 ~ 1000: 과제 마감일까지 남은 일수
            int w = Integer.parseInt(st.nextToken()); // 1 ~ 100: 과제 점수

            assignments[i] = new Assignment(d, w);
            maxDay = Math.max(maxDay, d);

            // 1000개에 대해 마감일과 점수를 각각 고려해서 모두 계산하는건 에바지 않나?
            // 마감일 / 점수 어떤걸 우선순위를 둬서 처리해야 하지?
            // 일단 점수를 기준으로 정렬한 다음에 하나에 하루씩 과제를 해결
        }

        Arrays.sort(assignments); // 점수 기준 정렬

        boolean[] days = new boolean[maxDay + 1];
        int totalScore = 0;

        for (Assignment a : assignments) {
            int day = a.deadline;
            while (day > 0 && days[day]) {
                day--;
            }

            if (day > 0) {
                days[day] = true;
                totalScore += a.score;
            }
        }

        System.out.println(totalScore);
    }
}