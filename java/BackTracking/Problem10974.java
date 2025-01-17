package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10974 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n  = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n + 1];
        dfs(0);
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
        
        // System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
