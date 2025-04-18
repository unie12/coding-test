package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2589 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int L, W;
    static int maxDistance = 0, maxX, maxY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 가로 50 이하
        W = Integer.parseInt(st.nextToken()); // 세로 50 이하

        map = new char[L][W];
        
        // 1. 각 육지마다 확인을 해야 함
        // 2. i에서 j까지 최단거리인데 가장 긴 경우를 찾아야 함
        // 근데 시작 위치가 고정되어 있는게 아닌데? -> 시작 위치 + 해당 육지까지의 거리 두 개를 저장?
        for (int i = 0; i < L; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0 ; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'W') {
                    continue;
                }
                bfs(i, j);
            }
        }
        System.out.println(maxDistance);
    }
    public static void bfs(int x, int y) {
        int[][] distnace = new int[L][W];
        boolean[][] visited = new boolean[L][W];

        for (int i = 0; i < L; i++) {
            Arrays.fill(distnace[i], -1);
        }
        
        visited[x][y] = true;
        distnace[x][y] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        int maxDist = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            maxDist = Math.max(maxDist, distnace[curX][curY]);
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= L || ny >= W) continue;
                if (map[nx][ny] == 'W' || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                distnace[nx][ny] = distnace[curX][curY] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        maxDistance = Math.max(maxDistance, maxDist);
    }
}
