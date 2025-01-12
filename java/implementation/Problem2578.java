package implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2578 {
    static int[][] bingo;
    static boolean[][] marked;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        bingo = new int[5][5];
        marked = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int callCount = 0;
        outer: for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                callCount++;
                int number = Integer.parseInt(st.nextToken());
                markNumber(number);

                if (checkBingo() >= 3) {
                    bw.write(callCount + "\n");
                    break outer;
                }
            }
        }
        
        bw.flush();
        bw.close();
    }

    private static void markNumber(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == number) {
                    marked[i][j] = true;
                    return;
                }
            }
        }
    }

    private static int checkBingo() {
        int bingoCount = 0;

        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) bingoCount++;
        }

        for (int j = 0; j < 5; j++) {
            boolean isBingo = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) bingoCount++;
        }

        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) bingoCount++;

        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][5 - i -1]) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) bingoCount++;

        return bingoCount;
    }
}
