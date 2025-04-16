package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem19539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++){
            int height = Integer.parseInt(st.nextToken());
            sum += height;
            count2 += height/2;
        }

        if (sum % 3 == 0 && count2 >= sum/3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
    }
}
