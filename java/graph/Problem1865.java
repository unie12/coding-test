package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1865 {
    static int[] distance;
    static List<Edge> edges;
    static int n;

    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 지점 1 ~ 500
            int m = Integer.parseInt(st.nextToken()); // 도로 1 ~ 2500
            int w = Integer.parseInt(st.nextToken()); // 웜홀 1 ~ 200

            edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                
                edges.add(new Edge(s, e, -t));
            }

            if (hasNegativeCycle()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean hasNegativeCycle() {
        distance = new int[n + 1];
        Arrays.fill(distance, 0);

        for (int i = 1; i <= n; i++) {
            boolean updated = false;

            for (Edge edge : edges) {
                if (distance[edge.to] > distance[edge.from] + edge.weight) {
                    distance[edge.to] = distance[edge.from] + edge.weight;
                    updated = true;

                    if (i == n) return true; // n번째 반복에서도 업데이트 발생 -> 음 사이클 존재?
                }
            }

            if (!updated) break;
        }
        return false;
    }
}
