package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16235 {
    static int[][] board;
    static int n;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int totaltime = 0;
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Position {
        int x, y, distance;

        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        int sharkX = 0, sharkY = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    board[i][j] = 0;
                }
            }
        }

        while (true) {
            Position nextFish = findNextFish(sharkX, sharkY);

            if (nextFish == null) break;

            sharkX = nextFish.x;
            sharkY = nextFish.y;
            board[sharkX][sharkY] = 0;

            totaltime += nextFish.distance;
            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(totaltime);
    }

    private static Position findNextFish(int x, int y) {
        boolean[][] visited = new boolean[n][n];
        Queue<Position> queue = new LinkedList<>();
        List<Position> candidates = new ArrayList<>();

        queue.offer(new Position(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (!candidates.isEmpty() && candidates.get(0).distance < current.distance) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue;

                if (board[nx][ny] <= sharkSize) {
                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny, current.distance + 1));

                    if (board[nx][ny] > 0 && board[nx][ny] < sharkSize) {
                        candidates.add(new Position(nx, ny, current.distance + 1));
                    }
                }
            }
        }

        if (candidates.isEmpty()) return null;

        Collections.sort(candidates, (a, b) -> {
            if (a.distance != b.distance) return a.distance - b.distance;
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        return candidates.get(0);
    }
}
