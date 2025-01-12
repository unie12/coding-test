package implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10994 {
    static char[][] pattern;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int size = 4 * n - 3;
        pattern = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pattern[i][j] = ' ';
            }
        }

        drawStar(0, size);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void drawStar(int start, int size) {
        if (size < 1) return;

        for (int i = start; i < start + size; i++) {
            pattern[start][i] = '*';
            pattern[start + size - 1][i] = '*';

            pattern[i][start] = '*';
            pattern[i][start + size - 1] = '*';
        }

        drawStar(start + 2, size - 4);
    }
}
