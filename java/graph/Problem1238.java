package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// public class Problem1238 {
//     static int n, m, x;
//     static int[][] graph;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//         x = Integer.parseInt(st.nextToken());

//         graph = new int[n + 1][n + 1];

//         for (int i = 1; i <= n; i++) {
//             Arrays.fill(graph[i], Integer.MAX_VALUE);
//             graph[i][i] = 0;
//         }

//         for (int i = 0; i < m; i++) {
//             st = new StringTokenizer(br.readLine());
//             int start = Integer.parseInt(st.nextToken());
//             int end = Integer.parseInt(st.nextToken());
//             int time = Integer.parseInt(st.nextToken());

//             graph[start][end] = time;
//         }

//         int maxTime = 0;
//         for (int i = 1; i <= n; i++) {
//             if (i == x) continue;
//             int toX = dijkstra(i, x);
//             int fromX = dijkstra(x, i);

//             maxTime = Math.max(maxTime, toX + fromX);
//         }

//         System.out.println(maxTime);
//     }

//     static int dijkstra(int start, int end) {
//         int[] distance = new int[n + 1];
//         boolean[] visited = new boolean[n + 1];

//         Arrays.fill(distance, Integer.MAX_VALUE);
//         distance[start] = 0;

//         for (int i = 0; i < n; i++) {
//             int min = Integer.MAX_VALUE;
//             int current = 0;

//             for (int j = 1; j <= n; j++) {
//                 if (!visited[j] && distance[j] < min) {
//                     min = distance[j];
//                     current = j;
//                 }
//             }

//             visited[current] = true;
//             if (current == end) break;

//             for (int j = 1; j <= n; j++) {
//                 if (!visited[j] && graph[current][j] != Integer.MAX_VALUE) {
//                     distance[j] = Math.min(distance[j], distance[current] + graph[current][j]);
//                 }
//             }
//         }
//         return distance[end];
//     }
// }

public class Problem1238 {
    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int n, m, x;
    static ArrayList<ArrayList<Edge>> graph, reverseGraph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, w));
            reverseGraph.get(v).add(new Edge(u, w));
        }

        int[] fromX = dijkstra(graph);
        int[] toX = dijkstra(reverseGraph);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, toX[i] + fromX[i]);
        }
        System.out.println(max);
    }

    private static int[] dijkstra(ArrayList<ArrayList<Edge>> g ) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        dist[x] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(x, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int node = cur.node;
            int cost = cur.cost;

            if (dist[node] < cost) continue;

            for (Edge next : g.get(node)) {
                int nextNode = next.node;
                int nextCost = cost + next.cost;

                if (dist[nextNode] > nextCost) {
                    dist[nextNode] = nextCost;
                    pq.offer(new Edge(nextNode, nextCost));
                }
            }
        }
        return dist;
    }
}