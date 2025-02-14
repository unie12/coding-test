import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1504 {
    static int n, e;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++ ){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long path1 = findPath(1, v1, v2, n);
        long path2 = findPath(1, v2, v1, n);
        long result = Math.min(path1, path2);

        System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
    }

    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static long findPath(int start, int mid1, int mid2, int end) {
        long result = 0;
        long path1 = dijkstra(start, mid1);
        long path2 = dijkstra(mid1, mid2);
        long path3 = dijkstra(mid2, end);

        if (path1 >= Integer.MAX_VALUE || path2 >= Integer.MAX_VALUE || path3 >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return path1 + path2 + path3;
    }

    public static int dijkstra(int start, int end) {
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        distance[start] = 0;
        pq.offer(new Edge(start, 0));
        
        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int curr = current.destination;

            if (visited[curr]) continue;
            visited[curr] = true;

            for (Edge next : graph[curr]) {
                if (!visited[next.destination] && distance[next.destination] > distance[curr] + next.weight) {
                    distance[next.destination] = distance[curr] + next.weight;
                    pq.offer(new Edge(next.destination, distance[next.destination]));
                }
            }
        }
        return distance[end];
    }
}
