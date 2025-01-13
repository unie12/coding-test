package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem12761 {
    static int a, b, n, m;
    static final int MAX = 100000;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken()); // 콩콩이 힘 1
        b = Integer.parseInt(st.nextToken()); // 콩콩이 힘 2
        n = Integer.parseInt(st.nextToken()); // 동규 위치
        m = Integer.parseInt(st.nextToken()); // 주미 위치

        // if ((Math.abs(n-m) % a == 0) || (Math.abs(n-m) % b == 0)) {
        //     System.out.println(1);
        //     return;
        // }

        System.out.println(bfs());
        /**
         * 1. +1
         * 2. -1
         * 3. +A
         * 4. +B
         * 5. -A
         * 6. -B
         * 7. *A 
         * 8. *B
         */
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[MAX + 1];

        queue.offer(new int[]{n, 0}); // {현재 위치, 이동 횟수}
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int steps = current[1];

            if (pos == m) return steps;

            int[] moves = {
                pos + 1, pos - 1,
                pos + a, pos - a,
                pos + b, pos - b,
                pos * a, pos * b
            };

            for (int next : moves) {
                if (next >= 0 && next <= MAX && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, steps + 1});
                }
            }
        }
        return -1;

    }
    
}
