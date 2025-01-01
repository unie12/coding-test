import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem22858 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 카드 개수
        int K = Integer.parseInt(st.nextToken()); // 셔플 횟수

        int[] S = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            D[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int k = 0; k < K; k++) {
            int[] temp = new int [N];
            for (int i = 0; i < N; i++) {
                temp[D[i]] = S[i];
            }
            S = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : S) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
        // bw.write(sb + "\n");

        // bw.flush();
        // bw.close();
    }
}