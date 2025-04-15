package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1946 {
    static class Grade implements Comparable<Grade> {
        int paper;
        int face;
        public Grade(int paper, int face) {
            this.paper = paper;
            this.face = face;
        }

        @Override
        public int compareTo(Grade other) {
            if (this.paper == other.paper) {
                return this.face - other.face;
            }
            return this.paper - other.paper;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Grade[] grades = new Grade[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int face = Integer.parseInt(st.nextToken());
                grades[i] = new Grade(paper, face);
            }

            Arrays.sort(grades);
            int count = 1;
            int minFace = grades[0].face; // 최소 면접 순위

            // 전체를 비교할 필요가 없음 -> 동석차가 없기 떄문
            // 그렇다면 어떻게 비교? 절반에 대해서 진행하면 되지 않나?
            // paper 하위 50%에 대해?
            for (int i = 0; i < n; i++) {
                if (grades[i].face < minFace) {
                    count++;
                    minFace = grades[i].face;
                }
            }

            System.out.println(count);
        }
        
    }
}
