package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11657 {
    static class Edge {
        int start;
        int destination;
        int weight;

        public Edge(int start, int destination, int weight) {
            this.start = start;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static int n, m;
    static List<Edge> graphs;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시 개수
        m = Integer.parseInt(st.nextToken()); // 버스 노선

        graphs = new ArrayList<>();
        distance = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graphs.add(new Edge(start, end, weight));
        }

        Arrays.fill(distance, INF);
        distance[1] = 0;

        boolean negativeCycle = bellmanFord();

        if (negativeCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (distance[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }

    public static boolean bellmanFord() {
        for (int i = 1; i < n; i++) {
            for (Edge graph : graphs) {
                if (distance[graph.start] == INF) continue;

                if (distance[graph.destination] > distance[graph.start] + graph.weight) {
                    distance[graph.destination] = distance[graph.start] + graph.weight;
                }
            }
        }

        for (Edge graph : graphs) {
            if (distance[graph.start] == INF) continue;

            if (distance[graph.destination] > distance[graph.start] + graph.weight) {
                return true;
            }
        }

        return false;
    }
}
 