package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2668 {
    static int n;
    static int[] board;
    static boolean[] visited;
    static boolean[] finished;
    static List<Integer> result;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[n + 1];
        finished = new boolean[n + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    public static void dfs(int index) {
        visited[index] = true;
        int next = board[index];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            int current = next;
            while (current != index) {
                result.add(current);
                current = board[current];
            }
            result.add(index);
        }

        finished[index] = true;
    }
}
