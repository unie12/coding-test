package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem14938 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 지역 개수 1 ~ 100
        int m = Integer.parseInt(st.nextToken()); // 수색 범위 1 ~ 15
        int r = Integer.parseInt(st.nextToken()); // 길 개수 1 ~ 100

        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        
        int[][] distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE / 2);
            distance[i][i] = 0;
        }
        
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            distance[start][end] = weight;
            distance[end][start] = weight;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int maxItems = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] <= m) {
                    sum += items[j];
                }
            }
            maxItems = Math.max(maxItems, sum);
        }
        System.out.println(maxItems);
    }
}
