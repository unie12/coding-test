import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trains = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken()) - 1;

            if (order == 1) {
                int seatNum = Integer.parseInt(st.nextToken()) - 1;
                trains[trainNum] |= (1 << seatNum);
            } else if (order == 2) {
                int seatNum = Integer.parseInt(st.nextToken()) - 1;
                trains[trainNum] &= ~(1 << seatNum);
            } else if (order == 3) {
                trains[trainNum] = (trains[trainNum] << 1) & ((1 << 20) - 1);
            } else if (order == 4) {
                trains[trainNum] = (trains[trainNum] >> 1);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int train : trains) {
            set.add(train);
        }

        bw.write(set.size() + "\n");
        bw.flush();
        bw.close();
    }
}
