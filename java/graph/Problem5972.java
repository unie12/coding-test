package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem5972 {
    static class Edge {
        int destination;
        int cost;

        Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    static ArrayList<Edge>[] graph;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
            graph[end].add(new Edge(start, weight));
        }

        dijkstra(1);
        System.out.println(distance[n]);
    }

    public static void dijkstra(int index) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        distance[index] = 0;
        pq.offer(new Edge(index, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.destination;
            int currentCost = current.cost;

            if (currentCost > distance[currentNode]) continue;

            for (Edge edge : graph[currentNode]) {
                int nextNode = edge.destination;
                int nextCost = edge.cost;

                if (currentCost + nextCost < distance[nextNode]) {
                    distance[nextNode] = nextCost + currentCost;
                    // System.out.println("distance[" + nextNode + "] = " + nextCost +  " + " + distance[currentNode]);
                    pq.offer(new Edge(nextNode, nextCost + currentCost));
                }
            }
        }
    }
}
