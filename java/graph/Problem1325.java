package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1325 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] hackCount;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        hackCount = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            hackCount[i] = bfs(i);
            // hackCount[i] = dfs(i);
        }

        int maxCount = 0;
        for (int i = 1; i <= n; i++) {
            maxCount = Math.max(maxCount, hackCount[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (hackCount[i] == maxCount) {
                sb.append(i).append(" ");
            }
        }
        // System.out.println(sb);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }

    // public static int dfs(int node) {
    //     visited[node] = true;
    //     int count = 1;

    //     for (int next : graph[node]) {
    //         if (!visited[next]) {
    //             count += dfs(next);
    //         }
    //     }
    //     // hackCount[node] = count;
    //     return count;
    // }
}
