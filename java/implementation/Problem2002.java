package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Problem2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        HashMap<String, Integer> inputMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inputMap.put(br.readLine(), i);
        }

        int count = 0;
        boolean[] passed = new boolean[n];

        for (int i = 0; i < n; i++) {
            String car = br.readLine();
            int originalPos = inputMap.get(car);

            for (int j = 0; j < originalPos; j++) {
                if (!passed[j]) {
                    count++;
                    break;
                }
            }
            passed[originalPos] = true;
        }
        System.out.println(count);
    }
}