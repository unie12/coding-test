package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] titles = new String[n];
        int[] powers = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());

            int left = 0;
            int right = powers.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (powers[mid] >= power) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(titles[left]);
        }

    }
}