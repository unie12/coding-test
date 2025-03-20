package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2638 {
    static int[][] graph;
    static int[][] air; // 1 = 내부 공기, 2 = 외부 공기
    static int n, m;
    static int endTime = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1. 치즈가 다 녹았는지 확인
        // 2. 치즈 외부/내부를 구별할 수 있어야 함
        // 3. 치즈 녹이기

        while (true) {
            if (!hasCheese()) break;

            markOutsideAir();

            meltChees();
            
            endTime++;
        }

        System.out.println(endTime);
    }

    public static boolean hasCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) return true;
            }
        }
        return false;
    }

    public static void markOutsideAir() {
        air = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        air[0][0] = 2;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (air[nx][ny] == 0 && graph[nx][ny] == 0) {
                    air[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0 && air[i][j] == 0) {
                    air[i][j] = 1;
                }
            }
        }
    }

    public static void meltChees() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = graph[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    int outAirCount = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + i;
                        int ny = dy[k] + j;
            
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (air[nx][ny] == 2) outAirCount++;
                    }
                    if (outAirCount >= 2) tmp[i][j] = 0;
                }
            }
        }
        graph = tmp;
    }
}