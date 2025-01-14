package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14248 {
    static int[] stones;
    static int n, s;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        stones = new int[n + 1];

        for (int i = 1 ; i <= n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        s = Integer.parseInt(br.readLine());
        bfs();

        int count = 0 ;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == true) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        queue.offer(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            int plusNext = current + stones[current];
            if (plusNext <= n && !visited[plusNext]) {
                queue.offer(plusNext);
                visited[plusNext] = true;
            }
            int minusNext = current - stones[current];
            if (minusNext >= 0 && !visited[minusNext]) {
                queue.offer(minusNext);
                visited[minusNext] = true;
            }
        }
    }
}
