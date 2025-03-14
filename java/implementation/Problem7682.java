package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem7682 {
    public static void main(String[] args) throws IOException {
        // 1. O X 개수 비교
        // 2. 3칸이 이어져 있는지 확인

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String test = br.readLine();
            if (test.equals("end")) {
                break;
            }

            int xCount = 0, oCount = 0;
            char[][] board = new char[3][3];

            // 1번
            for (int i = 0; i < 9; i++) {
                char c = test.charAt(i);

                board[i/3][i%3] = c;

                if (c == 'O') {
                    oCount++;
                } else if (c == 'X') {
                    xCount++;
                }
            }

            if (oCount > xCount || xCount - oCount > 1) {
                System.out.println("invalid");
                continue;
            }

            // 2번
            boolean xWin = checkWin(board, 'X');
            boolean oWin = checkWin(board, 'O');

            if (xWin && oWin) {
                // 둘 다 이기는 경우
                System.out.println("invalid");
            } else if (xWin) {
                // x가 이기는 경우 x가 o보다 1개 많아야 함
                if (xCount == oCount + 1) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            } else if (oWin) {
                // o가 이기는 경우 x와 o가 동일한 개수
                if (xCount == oCount) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            } else {
                if (xCount + oCount == 9) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            }
        }
    }

    private static boolean checkWin(char[][] board, char player) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // 세로
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // 대각선 1 -> 9
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        // 대각선 3 -> 7
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}