package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem16918 {
    static int r, c, n;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        if (n <= 1) {
            printBoard(board);
        } else if (n % 2 == 0) {
            printAll();
        } else if (n % 4 == 3) {
            board = bomb();
            printBoard(board);
        } else if (n % 4 == 1) {
            board = bomb();
            board = bomb();
            printBoard(board);
        }
    }

    static char[][] bomb() {
        char[][] temp = new char[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(temp[i], 'O');
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    temp[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                            temp[nx][ny] = '.';
                        }
                    }
                }
            }
        }
        return temp;
    }

    static void printAll() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append('O');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void printBoard(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append(board[i]).append("\n");
        }
        System.out.println(sb);
    }
}
