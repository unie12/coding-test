package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[366];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                arr[j]++;
            }
        }

        int area = 0;
        int width = 0, height = 0;
        for (int i = 1; i <= 365; i++) {
            if (arr[i] == 0) {
                area += (width * height);
                width = 0;
                height = 0;
            } else {
                width++;
                height = Math.max(height, arr[i]);
            }
        }

        if (width > 0) {
            area += (width * height);
        }
        System.out.println(area);
    }
}
