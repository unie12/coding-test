package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem1967 {
    static int n;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    static int maxDistance;
    static int farNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[parent].add(new Edge(child, weight));
            graph[child].add(new Edge(parent, weight));
        }

        // 1번째 dfs: 임의 노드에서 가장 먼 노드 찾기
        visited = new boolean[n + 1];
        maxDistance = 0;
        farNode = 1;
        dfs(1, 0);
        // 2번째 dfs: 1번째에서 찾은 노드에서 가장 먼 노드
        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(farNode, 0);

        System.out.println(maxDistance);
    }

    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void dfs(int curr, int distance) {
        visited[curr] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farNode = curr;
        }

        for (Edge edge : graph[curr]) {
            if (!visited[edge.destination]) {
                dfs(edge.destination, distance + edge.weight);
            }
        }
    }
}
