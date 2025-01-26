package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18111 { 
    static int n, m, b;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int minHeight = 256, maxHeight = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (minHeight > map[i][j])
                    minHeight = map[i][j];
                if (maxHeight < map[i][j])
                    maxHeight = map[i][j];
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;
        for (int i = minHeight; i <= maxHeight; i++) {
            int inventory = b;
            int time = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int diff = map[j][k] - i;

                    if (diff > 0) {
                        time += diff * 2;
                        inventory += diff;
                    } else if (diff < 0) {
                        time += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }
            if (inventory >= 0) {
                if (time <= answerTime) {
                    answerTime = time;
                    answerHeight = i;
                }
            }
        }
        System.out.println(answerTime + " " + answerHeight);
    }
}