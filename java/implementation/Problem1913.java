package implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1913 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int[][] result =  new int[n][n];
        int targetX = 0, targetY = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = 0, y = 0;
        int num = n*n;
        int direction = 0;

        while(num > 0) {
            result[x][y] = num;

            if (num == find) {
                targetX = x + 1;
                targetY = y + 1;
            }

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || result[nx][ny] != 0) {
                direction = (direction + 1) % 4;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
            num--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetX).append(" ").append(targetY);
        bw.write(sb + "\n");

        bw.flush();
        bw.close();
    }
}
