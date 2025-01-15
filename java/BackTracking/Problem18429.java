package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18429 {
    static int n, k, result;
    static int[] weights;
    static boolean[] visited;
    static int[] sequence;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        weights = new int[n];
        sequence = new int[n];
        visited = new boolean[n];
        result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(result);
    }    

    static void dfs(int depth) {
        if (depth == n) {
            if (isValid()) {
                result++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    static boolean isValid() {
        int weight = 500;
        for (int i = 0; i < n; i++) {
            weight += weights[sequence[i]] - k;
            if (weight < 500) return false;
        }
        return true;
    }
}
