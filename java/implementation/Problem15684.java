package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15684 {
    static int n, m, h;
    static int[][] arr;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로선 2 ~ 10
        m = Integer.parseInt(st.nextToken()); // 가로선 0 ~ (n-1)*h
        h = Integer.parseInt(st.nextToken()); // 세로선마다 가로선을 놓을 수 있는 위치 1 ~ 30
        arr = new int[h + 1][n + 1];

        if (m == 0) {
            System.out.println(0);
            return;
        }

        // 데이터를 어떻게 저장해야할까?
        // i번 세로줄에서 아래로 내려갈 떄 (a, b)가 있는지 확인해양 함
        // 이차원 배얄로 처리? 1인경우 오른쪽으로, -1이면 왼쪽으로 이동할 수 있게?

        // 가로선의 정보 (1 <= a <= h) (1 <= b <= n - 1)
        for (int i = 0; i <  m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
        }

        // 출력 -> i번 세로선의 결과가 i번이 나오도록
        // 정답이 3보다 큰 값이면 -1 출력, 불가능하면 -1 출력력
        for (int i = 0; i <= 3; i++) {
            backtrack(0, 0, i);
            if (answer != -1) {
                break;
            }
        }

        System.out.println(answer);
    }

    static void backtrack(int count, int depth, int target) {
        if (answer != -1 || count == target) {
            if (check()) {
                answer = count;
            }
            return;
        }

        for (int i = depth; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 1 || arr[i][j-1] == 1 || arr[i][j+1] == 1) {
                    continue;
                }

                arr[i][j] = 1;
                backtrack(count + 1, i, target);
                arr[i][j] = 0;
            }
        }

    }

    static boolean check() {
        for (int start = 1; start <= n; start++) {
            int current = start;

            for (int i = 1; i <= h; i++) {
                if (arr[i][current] == 1) {
                    current++;
                } else if (current > 1 && arr[i][current - 1] == 1) {
                    current--;
                }
            }

            if (current != start) {
                return false;
            }
        }

        return true;
    }
}
