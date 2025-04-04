package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15652 {
    static int n, m;
    static int[] arr;
    // static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        // visited = new boolean[n + 1];

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;  
        }
        for (int i = start; i <= n; i++) {
            // if (!visited[i]) {
                // visited[i] = true;
                arr[depth] = i;
                dfs(i, depth + 1);
                // visited[i] = false;
            // }
        }

    }
}
