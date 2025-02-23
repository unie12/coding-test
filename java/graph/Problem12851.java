package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem12851 {
    static int n, k;
    static int[] distance;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        distance = new int[100001];
        count = new int[100001];

        Arrays.fill(distance, -1);

        bfs(n);
        System.out.println(distance[k]);
        System.out.println(count[k]);
    }

    static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        distance[index] = 0;
        count[index] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int[] next= {current * 2, current + 1, current - 1};

            for (int nx : next) {
                if (nx < 0 || nx > 100000) continue;
                if (distance[nx] == -1) {
                    distance[nx] = distance[current] + 1;
                    count[nx] = count[current];
                    queue.offer(nx);
                } else if (distance[nx] == distance[current] + 1) {
                    count[nx] += count[current];
                }
            }
        }
    }
}
