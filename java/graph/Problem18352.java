package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem18352 {
    static ArrayList<Integer>[] road;
    static boolean[] visited;
    static int k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        road = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            road[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for (int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            road[a].add(b);
        }

        bfs(x);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[visited.length];
        Arrays.fill(distance, -1);

        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : road[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        boolean found = false;
        for (int i = 0 ; i < distance.length; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }

    }
    
}
