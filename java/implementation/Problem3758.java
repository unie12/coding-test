package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem3758 {
    static class Team {
        int id;
        int[] problemScores; // 각 문제별 최고 점수
        int totalScore;      // 총점
        int submissions;     // 제출 횟수
        int lastSubmitTime;  // 마지막 제출 시간
        
        public Team(int id, int problemCount) {
            this.id = id;
            this.problemScores = new int[problemCount + 1];
            this.totalScore = 0;
            this.submissions = 0;
            this.lastSubmitTime = 0;
        }

        public void submit(int problemNum, int score, int time) {
            submissions++;
            lastSubmitTime = time;

            if (problemScores[problemNum] < score) {
                totalScore = totalScore - problemScores[problemNum] + score;
                problemScores[problemNum] = score;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int p = 0; p < T; p++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀 개수 3 ~ 100
            int k = Integer.parseInt(st.nextToken()); // 문제 개수 3 ~ 100
            int t = Integer.parseInt(st.nextToken()); // 팀 ID 1 ~ n
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수 3 ~ 10000

            Team[] teams = new Team[n + 1];
            for (int i = 1; i <= n; i++) {
                teams[i] = new Team(i, k);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                teams[teamId].submit(problemNum, score, i);
            }

            // 팀 순위 계산 -> 최종 점수가 높은 순서
            // 최종 점수가 같은 경우 풀이 횟수 적은 팀
            // 최종 점수, 풀이 횟수 같은 경우 마지막 제출 시간이 더 빠른 팀
            // 팀 ID, 최종 점수, 풀이 횟수, 제출 시간

            Arrays.sort(teams, 1, n + 1, (a, b) -> {
                if (a.totalScore != b.totalScore) {
                    return b.totalScore - a.totalScore;
                }
                if (a.submissions != b.submissions) {
                    return a.submissions - b.submissions;
                }
                return a.lastSubmitTime - b.lastSubmitTime;
            });

            int myRank = 1;
            for (int i = 1; i <= n; i++) {
                if (teams[i].id == t) {
                    break;
                }
                myRank++;
            }
            System.out.println(myRank);
        }
        
    }
}
