import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem11659 {
    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        long[] prefixSum = new long[n + 1];
        // int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
            // arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // long sum = 0;
            // for (int j = start - 1; j <= end -1; j++) {
                // sum += arr[j];
            // }
            // sb.append(sum).append("\n");
            sb.append(prefixSum[end] - prefixSum[start-1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        
    }
}
