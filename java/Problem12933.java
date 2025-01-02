import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem12933 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String cryStrings = br.readLine();
        int len = cryStrings.length();
        boolean[] used = new boolean[len];

        if (len % 5 != 0 || cryStrings.charAt(0) != 'q') {
            System.out.println(-1);
            return;
        }

        int duckCount = 0;
        for (int i = 0; i < len; i++) {
            if (used[i] || cryStrings.charAt(i) != 'q') continue;

            boolean foundDuck = false;
            int idx = 0;
            String quack = "quack";

            for (int j = i; j < len; j++) {
                if (!used[j] && cryStrings.charAt(j) == quack.charAt(idx)) {
                    used[j] = true;
                    if (idx == 4) { // k인지 검사하는데 아직도 오이를 못 찾은 경우 -> 새로운 오리가 있음을 알 수 있음
                        if (!foundDuck) {
                            duckCount++;
                            foundDuck = true;
                        }
                        idx = 0;
                        continue;
                    }
                    idx++;
                }
            }

            if (!foundDuck) {
                System.out.println(-1);
                return;
            }
        }

        for (boolean u : used) {
            if (!u) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(duckCount);
    }
}