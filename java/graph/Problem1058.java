package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1058 {
    static boolean[] visited;
    static ArrayList<Integer>[] friends;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        friends = new ArrayList[n];
        for (int i = 0 ; i < n; i++) {
            friends[i] = new ArrayList<>();
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'Y') {
                    friends[i].add(j);
                }
            }
        }

        int maxFriends = 0;
        for (int i = 0; i < n; i++) {
            maxFriends = Math.max(maxFriends, bfs(i));
        }
        System.out.println(maxFriends);
    }

    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n];
        visited[start] = true;
        queue.offer(new int[]{start, 0});

        int count = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];

            if (depth <= 1) {
                for (int next : friends[node]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        count++;
                        queue.offer(new int[]{next, depth + 1});
                    }
                }
            }
        }
        return count;
    }
}
