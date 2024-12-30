import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem4396 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] mineMap = new char[n][n];
        char[][] gameMap = new char[n][n];
        char[][] resultMap = new char[n][n];

        for (int i = 0; i < n; i++) {
            mineMap[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            gameMap[i] = br.readLine().toCharArray();
        }

        boolean mineHit = false;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultMap[i][j] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (gameMap[i][j] == 'x') {
                    if (mineMap[i][j] == '*') {
                        mineHit = true;
                    } else {
                        int mineCount = 0;
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < n && ny >=0 && ny < n && mineMap[nx][ny] == '*') {
                                mineCount++;
                            }
                        }
                        resultMap[i][j] = (char) (mineCount + '0');
                    }
                }
            }
        }

        if (mineHit) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mineMap[i][j] == '*') {
                        resultMap[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(resultMap[i]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
