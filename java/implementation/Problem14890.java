package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14890 {
    static int n, l;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1. 평평한 곳과 경사 있는 곳이 L만큼 차이 있어야 함
        // 2. 이미 경사로가 존재하는지 확인해야 함(높은 곳 <-> 낮은 곳 분류해야 한다?)
        // 낮은 곳의 평평이 L 이상

        // 가로
        for (int i = 0; i < n; i++) {
            if (canGo(i, true)) {
                result++;
            }
        }

        // 세로
        for (int i = 0; i < n; i++) {
            if (canGo(i, false)) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean canGo(int line, boolean isRow) {
        boolean[] slope = new boolean[n];
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            if (isRow) {
                height[i] = map[line][i];
            } else {
                height[i] = map[i][line];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (height[i] == height[i + 1]) continue;

            if (Math.abs(height[i] - height[i + 1]) > 1) return false;

            // 낮 -> 높
            if (height[i] < height[i + 1]) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || slope[i - j] || height[i] != height[i - j]) return false;

                    slope[i - j] = true;
                }
            } 
            // 높 -> 낮
            else {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || slope[i + j] || height[i + 1] != height[i + j]) return false;

                    slope[i + j] = true;
                }
            }
        }

        return true;
    }
}
