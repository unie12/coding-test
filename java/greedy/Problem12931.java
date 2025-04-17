package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12931 {
    static int result = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1 ~ 50
        // 0 ~ 1000
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 이게 진짜 일일히 다 greedy로 한다고? 이건 말이 안된다고 생각. 일단 방법이 2개니까
        // 2. 일단 만들어진 배열에서 태초 배열로 돌아가는식이 알맞을 듯
        // 그렇다면 어떻게 돌아갈 것인가? bfs, simulation
        // 모든 배열의 수가 0 or 2의 배수가 아니라면 2배 방법은 못씀

        simulation(arr);
        System.out.println(result);
    }

    public static void simulation(int[] arr) {
        while (!allZero(arr)) {
            // 홀수인 원소들을 모두 찾아서 1씩 빼기
            boolean foundOdd = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 != 0) {
                    arr[i]--;
                    result++;
                    foundOdd = true;
                }
            }
            
            // 홀수가 없었다면(모두 짝수였다면) 전체를 2로 나누기
            if (!foundOdd) {
                for (int i = 0; i < n; i++) {
                    arr[i] /= 2;
                }
                result++;
            }
        }
    }
    

    public static boolean allZero(int[] arr) {
        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
    }
}
