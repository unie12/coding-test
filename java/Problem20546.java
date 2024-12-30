import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[14];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 준현
        int money1 = N;
        int stock1 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (money1 / arr[i] > 0) {
                int cnt = money1 / arr[i];
                stock1 += cnt;
                money1 -= arr[i] * cnt;
            }
        }

        // 성민
        int money2 = N;
        int stock2 = 0;
        
        for (int i = 0; i < arr.length - 3; i++) {
            if ((arr[i] < arr[i+1]) && (arr[i+1] < arr[i+2])) {
                if (stock2 == 0) continue;

                money2 += arr[i+3] * stock2;
                stock2 = 0;
            } else if ((arr[i] > arr[i+1]) && (arr[i+1] > arr[i+2])) {
                if (money2 / arr[i+3] > 0) {
                    int cnt = money2 / arr[i+3];
                    stock2 += cnt;
                    money2 -= arr[i+3] * cnt;
                }
            }
        }

        int profit1 = money1 + arr[arr.length - 1] * stock1;
        int profit2 = money2 + arr[arr.length - 1] * stock2;

        if(profit1 > profit2) {
            // System.out.println("BNP");
            bw.write("BNP\n");
        } else if (profit1 < profit2) {
            // System.out.println("TIMING");
            bw.write("TIMING\n");
        } else {
            // System.out.println("SAMESAME");
            bw.write("SAMESAME\n");
        }

        bw.flush();
        bw.close();
    }
}