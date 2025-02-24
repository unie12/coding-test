package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem11779 {
    static class Edge {
        int destination;
        int cost;

        public Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    static int n, m;
    static ArrayList<Edge>[] graph;
    static int[] distance;
    static int[] prev;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        prev = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = INF;
            prev[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(distance[end]);

        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println(path.size());

        for (int city : path) {
            System.out.print(city + " ");
        }

    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        distance[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.destination;
            int currentCost = current.cost;

            if (currentCost > distance[currentNode]) continue;

            for (Edge edge : graph[currentNode]) {
                int nextNode = edge.destination;
                int nextCost = edge.cost + currentCost;

                if (nextCost < distance[nextNode]) {
                    distance[nextNode] = nextCost;
                    prev[nextNode] = currentNode;

                    pq.offer(new Edge(nextNode, nextCost));
                }
            }
        }
    }
}
