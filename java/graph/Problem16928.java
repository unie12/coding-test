package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16928 {
    static int[] dist;
    static int[] board;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[101];
        Arrays.fill(dist, -1);
        board = new int[101];
        for (int i = 1; i < 101; i++) {
            board[i] = i;
        }
        // 사다리
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a] = b;
        }

        bfs();
        System.out.println(dist[100]);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;

                next = board[next];

                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
            
        }
    }
}
