package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem11725 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] parents;
         
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        parents = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int child : graph[node]) {
            if (!visited[child]) {
                parents[child] = node;
                dfs(child);
            }
        }
    }
}