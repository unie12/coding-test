import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2615 {
    static int[][] board = new int[20][20];

    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if(board[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        if (checkOmok(i, j, k)) {
                            System.out.println(board[i][j]);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean checkOmok(int x, int y, int dir) {
        int stone = board[x][y];
        int count = 1;

        // 이전 방향 확인해서 육목 확인
        int prevX = x - dx[dir];
        int prevY = y - dy[dir];
        if(isValid(prevX, prevY) && board[prevX][prevY] == stone) {
            return false;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while(isValid(nx, ny) && board[nx][ny] == stone) {
            count++;
            nx += dx[dir];
            ny += dy[dir];
        }

        return count == 5;
    }

    static boolean isValid(int x, int y) {
        return x > 0 && x <= 19 && y >0 && y <= 19;
    }
}

