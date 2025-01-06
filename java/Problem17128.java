import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem17128 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        long[] products = new long[N];
        long totalSum = 0;
        for (int i = 0; i < N; i++) {
            products[i] = (long)cows[i] * cows[(i+1)%N] * cows[(i+2)%N] * cows[(i+3)%N];
            totalSum += products[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int idx = Integer.parseInt(st.nextToken()) - 1;
            cows[idx] *= -1;

            for (int j = 0; j < 4; j++) {
                int targetIdx = (idx - j + N) % N;
                totalSum -= 2 * products[targetIdx];
                products[targetIdx] *= -1;
            }

            bw.write(totalSum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
