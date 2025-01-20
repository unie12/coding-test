package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

public class Problem11723 {
    static int arr[] = new int[21];
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int value = 0;
            if (!operation.equals("all") && !operation.equals("empty")) {
                value = Integer.parseInt(st.nextToken());
            }

            if (operation.equals("add")) {
                arr[value] = 1;
            } else if (operation.equals("remove")) {
                arr[value] = 0;
            } else if (operation.equals("check")) {
                sb.append(arr[value]).append('\n');
            } else if (operation.equals("toggle")) {
                arr[value] = arr[value] == 1 ? 0 : 1;
            } else if (operation.equals("all")) {
                Arrays.fill(arr, 1);
            } else {
                Arrays.fill(arr, 0);
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}
