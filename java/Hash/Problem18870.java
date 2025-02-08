package Hash;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem18870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int rank = 0;
        for (int value : sorted) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank++);
            }
        }

        for (int value : arr) {
            sb.append(rankMap.get(value)).append(' ');
        }
        System.out.println(sb);

    }
}
