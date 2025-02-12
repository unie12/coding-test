package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem9019 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfs(a, b);
        }
        System.out.println(sb);
    }

    public static void bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        queue.offer(new Node(a, ""));
        visited[a] = true;

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.num == b) {
                // System.out.println(current.command);
                sb.append(current.command).append("\n");
                return;
            }

            // D: 2n mod 10000
            int d = (current.num * 2) % 10000;
            if (!visited[d]) {
                visited[d] = true;
                queue.offer(new Node(d, current.command + "D"));
            }
            // S: n-1 (n이 0이면 9999)
            int s = current.num == 0 ? 9999 : current.num - 1;
            if (!visited[s]) {
                visited[s] = true;
                queue.offer(new Node(s, current.command + "S"));
            }
            // L: 왼쪽 회전
            int l = (current.num % 1000) * 10 + current.num / 1000;
            if (!visited[l]) {
                visited[l] = true;
                queue.offer(new Node(l, current.command + "L"));
            }
            // R: 오른쪽 회전
            int r = (current.num % 10) * 1000 + current.num / 10;
            if (!visited[r]) {
                visited[r] = true;
                queue.offer(new Node(r, current.command + "R"));
            }
        }

    }

    static class Node {
        int num;
        String command;

        Node(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }
}
