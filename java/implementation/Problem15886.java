package implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem15886 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String moving = br.readLine();
        int present = 0;

        for (int i = 0; i < n-1; i++) {
            if (moving.charAt(i) == 'E' && moving.charAt(i + 1) == 'W') {
                present++;
            }
        }

        bw.write(String.valueOf(present));
        bw.flush();
        bw.close();
        br.close();
    }
}
