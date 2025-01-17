package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem20950 {
    static int n, m;
    static int[][] colors;
    static int[] mixed = new int[3];
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        colors = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetR = Integer.parseInt(st.nextToken());
        int targetG = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= Math.min(7, n); i++) {
            m = i;
            combination(0, 0, 0, 0, 0, targetR, targetG, targetB);
        }

        System.out.println(minDiff);
    }

    public static void combination(int depth, int start, int sumR, int sumG, int sumB, int targetR, int targetG, int targetB) {
        if (depth == m) {
            int avgR = sumR / m;
            int avgG = sumG / m;
            int avgB = sumB / m;

            int diff = Math.abs(targetR - avgR) + Math.abs(targetG - avgG) + Math.abs(targetB - avgB);
            minDiff = Math.min(minDiff, diff);
            return;
        }

        for (int i = start; i < n; i++) {
            combination(depth + 1, i + 1, sumR + colors[i][0], sumG + colors[i][1], sumB + colors[i][2], targetR, targetG, targetB);
        }
    }
}
