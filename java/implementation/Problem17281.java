package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem17281 {
    static int n;
    static int[][] results;
    static int[] order = new int[10];
    static boolean[] selected = new boolean[10];
    static int maxScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 2 ~ 50
        results = new int[n + 1][10];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                results[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0: 아웃
        // 1: 안타
        // 2: 2루타 
        // 3: 3루타 
        // 4: 홈런 
        // 1번 선수가 4번 타자 확정

        order[4] = 1;
        selected[1] = true;

        permutaion(1);
        System.out.println(maxScore);
    }

    static void permutaion(int depth) {
        if (depth == 10) {
            playGame();
            return;
        }

        if (depth == 4) {
            permutaion(depth + 1);
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (!selected[i]) {
                selected[i] = true;
                order[depth] = i;
                permutaion(depth + 1);
                selected[i] = false;
            }
        }
    }

    static void playGame() {
        int score = 0;
        int hitter= 1;

        for (int inning = 1; inning <= n; inning++) {
            int out = 0;
            boolean[] bases = new boolean[4];

            while (out < 3) {
                int player = order[hitter];
                int hit = results[inning][player];

                switch (hit) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        if (bases[3]) score++;
                        bases[3] = bases[2];
                        bases[2] = bases[1];
                        bases[1] = true;
                        break;
                    case 2:
                        if (bases[3]) score++;
                        if (bases[2]) score++;
                        bases[3] = bases[1];
                        bases[2] = true;
                        bases[1] = false;
                        break;
                    case 3:
                        if (bases[3]) score++;
                        if (bases[2]) score++;
                        if (bases[1]) score++;
                        bases[3] = true;
                        bases[2] = false;
                        bases[1] = false;
                        break;
                    case 4:
                        if (bases[3]) score++;
                        if (bases[2]) score++;
                        if (bases[1]) score++;
                        score++;
                        bases[3] = false;
                        bases[2] = false;
                        bases[1] = false;
                        break;
                }
                hitter = (hitter % 9) + 1;
            }
        }
        maxScore = Math.max(maxScore, score);
    }
}
