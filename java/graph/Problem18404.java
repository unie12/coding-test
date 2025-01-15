package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem18404 {
    static int n, m, x, y;
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<int[]> targets = new ArrayList<>();
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int tmpX = Integer.parseInt(st.nextToken());
            int tmpy = Integer.parseInt(st.nextToken());
            targets.add(new int[]{tmpX, tmpy});
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int[] target : targets) {
            sb.append(board[target[0]][target[1]]).append(" ");
        }
        System.out.println(sb);
    }


    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx <= 0 || ny <= 0 || nx > n || ny > n)
                    continue;
                if (visited[nx][ny])
                    continue;

                board[nx][ny] = board[current[0]][current[1]] + 1;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }


    }
}
