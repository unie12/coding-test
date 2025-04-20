package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem18405 {
    static int n, k, s, x, y;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 1 ~ 200 격자 크기
        k = Integer.parseInt(st.nextToken()); // 1 ~ 1000 바이러스 종류
        arr = new int[n + 1][n + 1];

        PriorityQueue<Virus> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    pq.offer(new Virus(arr[i][j], i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()); // s초 뒤
        x = Integer.parseInt(st.nextToken()); // 확인할 x좌표
        y = Integer.parseInt(st.nextToken()); // 확인할 y좌표

        while (!pq.isEmpty()) {
            Virus virus = pq.poll();

            if (virus.time == s) break;

            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if (arr[nx][ny] != 0) continue;

                arr[nx][ny] = virus.num;
                pq.offer(new Virus(virus.num, nx, ny, virus.time + 1));
            }
        }

        System.out.println(arr[x][y]);
    }

    static class Virus implements Comparable<Virus> {
        int num, x, y, time;

        public Virus(int num, int x, int y, int time) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Virus o) {
            if (this.time == o.time) {
                return this.num - o.num;
            }
            return this.time - o.time;
        }
    }
}
