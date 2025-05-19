package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1261 {
    static int n, m;
    static int[][] miro;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        miro = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                miro[i][j] = s.charAt(j - 1) - '0';
            }
        }

        // (1, 1)에서 (n, m)까지 이동할 때 최소 몇 개의 벽을 부셔야 하는가?
        // 최단 거리가 아니라 벽을 최소 몇 개 부수어야 하는지가 중요
        // 1. 벽을 부수지 않고 이동할 수 있는 애들을 모두 큐에 일단 넣어놓기. 이후 벽을 1개씩 부셔가면서 가능한지 확인??
        bfs(1, 1);
    }

    public static void bfs(int x, int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n + 1][m + 1];

        pq.offer(new int[]{x, y, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentX = current[0];
            int currentY = current[1];
            int broken = current[2];

            if (visited[currentX][currentY]) continue;
            visited[currentX][currentY] = true;

            if (currentX == n && currentY == m) {
                System.out.println(broken);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if (visited[nx][ny]) continue;

                if (miro[nx][ny] == 1) {
                    pq.offer(new int[]{nx, ny, broken + 1});
                } else {
                    pq.offer(new int[]{nx, ny, broken});
                }
            }

        }

    }
}
