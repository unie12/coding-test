import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 집 2 ~ 200000
        int c = Integer.parseInt(st.nextToken()); // 공유기 2 ~ n
        int[] house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int start = 1; // 최소 거리
        int end = house[n-1] - house[0]; // 최대 거리
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            int count = 1;
            int prevHouse = house[0];

            for (int i = 1; i < n; i++) {
                if (house[i] - prevHouse >= mid) {
                    count++;
                    prevHouse = house[i];
                }
            }

            if (count >= c) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
