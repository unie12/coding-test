package implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int switchCount = Integer.parseInt(br.readLine());
        int[] switches = new int[switchCount + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= switchCount; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = number; j <= switchCount; j += number) {
                    switches[j] = 1 - switches[j];
                }
            } else if (gender == 2) {
                int left = number;
                int right = number;
                
                switches[number] = 1 - switches[number];
                while (left > 1 && right < switchCount && switches[left - 1] == switches[right + 1]) {
                    left--;
                    right++;
                    switches[left] = 1 - switches[left];
                    switches[right] = 1 - switches[right];
                }
            }
        }
        for (int i = 1; i <= switchCount; i++) {
            bw.write(switches[i] + " ");
            if (i % 20 == 0) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
