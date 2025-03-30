package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem3190 {
    static int n, k, l;
    static int[][] board;
    static Map<Integer, Character> directionChanges = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            directionChanges.put(time, direction);
        }

        System.out.println(simulate());
    }

    public static int simulate() {
        int time = 0;
        int direction = 0;
        Deque<int[]> snake = new ArrayDeque<>();
        snake.offerFirst(new int[]{1, 1});

        while (true) {
            time++;
            int[] head = snake.peekFirst();
            int nx = head[0] + dx[direction];
            int ny = head[1] + dy[direction];

            if (nx < 1 || nx > n || ny < 1 || ny > n || isSnakeBody(snake, nx, ny)) break;

            if (board[nx][ny] == 1) {
                board[nx][ny] = 0;
            } else {
                snake.pollLast();
            }

            snake.offerFirst(new int[]{nx, ny});
            if (directionChanges.containsKey(time)) {
                direction = changeDirection(direction, directionChanges.get(time));
            }
        }

        return time;
    }

    public static boolean isSnakeBody(Deque<int[]> snake, int x, int y) {
        for (int[] body : snake) {
            if (body[0] == x && body[1] == y) return true;
        }
        return false;
    }

    public static int changeDirection(int currentDirection, char change) {
        if (change == 'L') {
            return (currentDirection + 3) % 4;
        } else {
            return (currentDirection + 1) % 4;
        }
    }
}
