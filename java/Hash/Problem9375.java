package Hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String ,Integer> clothes = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();
                clothes.put(category, clothes.getOrDefault(category, 0) + 1);
            }

            int answer = 1;
            for (Integer count : clothes.values()) {
                answer *= (count + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
