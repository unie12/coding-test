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

public class Problem18232 {
    static int n, m, s, e;
    static ArrayList<Integer>[] station;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());   
        n = Integer.parseInt(st.nextToken()); // 1 ~ n 정거장
        m = Integer.parseInt(st.nextToken()); // 텔레포트 정보 m개
        
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()); // 출발 장소 s
        e = Integer.parseInt(st.nextToken()); // 도착 장소 e

        station = new ArrayList[n + 1];
        for (int i = 0; i < n+1; i++) {
            station[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            station[x].add(y);
            station[y].add(x);
        }

        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        queue.offer(s);
        distance[s] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == e) {
                System.out.println(distance[current]);
                return;
            }

            // 좌로 움직임
            if (current - 1 >= 1 && distance[current - 1] == -1) {
                queue.offer(current - 1);
                distance[current - 1] = distance[current] + 1;
            }
            // 우로 움직임
            if (current + 1 <= n && distance[current + 1] == -1) {
                queue.offer(current + 1);
                distance[current + 1] = distance[current] + 1;
            }
            // 텔레포트
            for (int next : station[current]) {
                if (distance[next] == -1) {
                    queue.offer(next);
                    distance[next] = distance[current] + 1;
                }
            }
        }
    }
}
