package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            result.add(arr[i], i + 1);
            // System.out.println("index: " + arr[i] + " value: " + (i + 1));
        }
        
        for (int num : result) {
            System.out.print(num + " ");
        }
        
    }
}
