import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18311 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st. nextToken());
        int[] course = new int[100000];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            course[i] = Integer.parseInt(st.nextToken());
        }

        long distance = 0;

        for (int i = 0; i < N; i++) {
            distance += course[i];

            if (distance > K) {
                System.out.println(i + 1);
                return;
            } else if (distance == K) {
                System.out.println(i + 2);
                return;
            }
        }

        for (int i = N-1; i >= 0; i--) {
            distance += course[i];

            if (distance >= K) {
                System.out.println(i + 1);
                return;
            } else if (distance == K) {
                System.out.println(i + 2);
                return;
            }
        }

        
    }
}
