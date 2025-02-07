import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] budget = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxBudget = 0, sumBudget = 0;

        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            maxBudget = Math.max(maxBudget, budget[i]);
            sumBudget += budget[i];
        }

        int m = Integer.parseInt(br.readLine());
        if (sumBudget <= m) {
            System.out.println(maxBudget);
            return;
        }

        int left = 1;
        int right = maxBudget;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            sumBudget = 0;
            for (int b : budget) {
                sumBudget += Math.min(b, mid);
            }

            if (sumBudget <= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
