package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem15566 {
    static int n, m;
    static int[][] frog; // 개구리 흥미
    static List<Integer>[] frog_lotus; // 개구리 선호 연꽃
    static int[][] log; // 통나무 정보
    static int[] lotus; // 연꽃에 배치된 개구리
    static boolean result;
    static StringBuilder sb;
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 개구리 흥미도
        frog = new int[n][4];
        for (int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 4; j++) {
                frog[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 개구리 선호 연꽃
        frog_lotus = new ArrayList[n];
        for (int i = 0 ; i < n; i++) {
            frog_lotus[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (a == b) {
                frog_lotus[i].add(a);
            } else {
                frog_lotus[i].add(a);
                frog_lotus[i].add(b);
            }
        }

        // 통나무 정보
        log = new int[m][3];
        for (int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 3; j ++) {
                log[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        lotus = new int[n];
        Arrays.fill(lotus, -1);
        result = false;
        sb = new StringBuilder();

        permutation(0);

        if (result) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }

    private static void permutation(int cnt) {
        if (cnt == n) {
            checkValid();
            return;
        }

        for (int i = 0; i < frog_lotus[cnt].size(); i++) {
            int ycc = frog_lotus[cnt].get(i);
            if (lotus[ycc] == -1) {
                lotus[ycc] = cnt;
                permutation(cnt + 1);
                if (result) return;
                lotus[ycc] = -1;
            }
        }
    }

    private static void checkValid() {
        for (int i = 0; i < m; i++) {
            int ycc1 = log[i][0];
            int ycc2 = log[i][1];
            int title = log[i][2];
            int frog1 = lotus[ycc1];
            int frog2 = lotus[ycc2];
            if (frog[frog1][title] != frog[frog2][title]) {
                return;
            }
        }

        result = true;
        sb.append("YES\n");
        for (int i = 0; i < n; i++) {
            sb.append((lotus[i] + 1) + " ") ;
        }
    }
}