package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem21608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 3 ~ 20
        List<Integer>[] priorityLists = new ArrayList[n * n + 1];
        int[] order = new int[n * n];

        for (int i = 1; i <= n * n; i++) {
            priorityLists[i] = new ArrayList<>();
        }


        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            order[i] = studentNum;

            for (int j = 0; j < 4; j++) {
                priorityLists[studentNum].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 선호도 입력받은 학생 순서대로 진행해야 함
        // 먼저 자신이 선호하는 학생이 존재하는지 확인
        // 없으면 좌측 상단으로
        // 1. 있다면 좋아하는 학생이 인접한 칸에 가장 많은 칸으로
        // 2. 1을 만족하는 칸이 여러 개이면 인접한 칸 중에서 비어있는 칸이 가장 많은 칸
        // 3. 2를 만족하는 칸 여러 개이면 좌측 상단으로

        int[][] classroom = new int[n + 1][n + 1];
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        int score = 0;
        
        for (int i = 0; i < n * n; i++) {
            int student = order[i];
            int maxLike = -1, maxEmpty = -1;
            int bestRow = 0, bestCol = 0;

            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= n; c++) {
                    if (classroom[r][c] != 0) continue;

                    int likeCnt = 0;
                    int emptyCnt = 0;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr < 1 || nc < 1 || nr > n || nc > n) continue;
                        if (classroom[nr][nc] == 0) emptyCnt++;
                        else if (priorityLists[student].contains(classroom[nr][nc])) likeCnt++; 
                    }

                    if (likeCnt > maxLike || (likeCnt == maxLike && emptyCnt > maxEmpty) || (likeCnt == maxLike && emptyCnt == maxEmpty && (r < bestRow || (r == bestRow && c < bestCol)))) {
                        maxLike = likeCnt;
                        maxEmpty = emptyCnt;
                        bestRow = r;
                        bestCol = c;
                    }
                }
            }
            classroom[bestRow][bestCol] = student;
        }
        
        // 인접한 칸에 좋아하는 학생 수에 따른 만족도
        // 0 -> 0
        // 1 -> 1
        // 2 -> 10
        // 3- > 100
        // 4 -> 1000
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int student = classroom[i][j];
                int likeCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr < 1 || nc < 1 || nr > n || nc > n) continue;
                    if (priorityLists[student].contains(classroom[nr][nc])) likeCnt++; 
                }

                if (likeCnt == 1) score++;
                else if (likeCnt == 2) score += 10;
                else if (likeCnt == 3) score += 100;
                else if (likeCnt == 4) score += 1000;
            }
        }

        System.out.println(score);
    }
}
