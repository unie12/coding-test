package implementation;

import java.io.*;
import java.util.*;

public class Problem1091 {
    static int[] S;
    static int[] P;
    static int[] current;
    static int[] init;
    static int n;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = new int[n];
        S = new int[n];
        current = new int[n];
        init = new int[n];

        for (int i = 0; i < n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            current[i] = i; 
            init[i] = i;   
        }

        while (!check()) {
            shuffle();
            result++;
            if (impossible()) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(result);
    }

    public static boolean check() {
        for (int i = 0; i < n; i++) {
            if (P[current[i]] != i % 3) {
                return false;
            }
        }
        return true;
    }

    public static void shuffle() {
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            next[S[i]] = current[i];
        }
        for (int i = 0; i < n; i++) {
            current[i] = next[i];
        }
    }

    public static boolean impossible() {
        for (int i = 0; i < n; i++) {
            if (current[i] != init[i]) {
                return false;
            }
        }
        return true;
    }
}
