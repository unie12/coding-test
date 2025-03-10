import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] belt = new int[n];
        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        // 초밥 종류별 먹은 개수를 저장하는 배열
        int[] sushiCount = new int[d + 1];
        int uniqueCount = 0;
        int maxCount = 0;

        // 초기 윈도우 설정
        for (int i = 0; i < k; i++) {
            if (sushiCount[belt[i]] == 0) {
                uniqueCount++;
            }
            sushiCount[belt[i]]++;
        }

        maxCount = sushiCount[c] == 0 ? uniqueCount + 1 : uniqueCount;

        for (int i = 1; i < n; i++) {
            int removeIndex = belt[i - 1];
            sushiCount[removeIndex]--;
            if (sushiCount[removeIndex] == 0) {
                uniqueCount--;
            }

            int addIndex = belt[(i + k - 1) % n];
            if (sushiCount[addIndex] == 0) {
                uniqueCount++;
            }
            sushiCount[addIndex]++;

            maxCount = Math.max(maxCount, sushiCount[c] == 0 ? uniqueCount + 1 : uniqueCount);
        }

        System.out.println(maxCount);
    }
}
