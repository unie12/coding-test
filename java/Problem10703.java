import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][S];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int minDis = R;
        for (int j = 0; j < S; j++) {
            int lastMeteor = -1;
            int firstGround = R;

            for (int i = 0; i < R; i++) {
                if (map[i][j] == 'X') {
                    lastMeteor = i;
                } else if (map[i][j] == '#') {
                    firstGround = i;
                    break;
                }
            }

            if (lastMeteor != -1) {
                minDis = Math.min(minDis, firstGround - lastMeteor - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                if (i - minDis >= 0 && map[i - minDis][j] == 'X') {
                    sb.append('X');
                } else if (map[i][j] == '#') {
                    sb.append('#');
                } else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
}
