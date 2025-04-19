package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1,000,000

        // 각 자리수마다 감소하는 수 구하기?
        // 0 ~ 9까지 10개 존재
        // 10부터 19까지 몇 개 재하는지, 20 ~ 29, ```
        // 9876543210 -> 최대 감소하는 수

        if (n > 1022) {
            System.out.println(-1);
            return;
        }

        if (n <= 9) {
            System.out.println(n);
            return;
        }

        List<Long> decreasing = new ArrayList<>();
        Queue<Long> queue = new LinkedList<>();
        for (long i = 1; i <= 10; i++) {
            queue.add(i);
            decreasing.add(i);
        }

        while (!queue.isEmpty()) {
            long current = queue.poll();
            long lastDigit = current % 10;

            for (long i = 0; i < lastDigit; i++) {
                long next = current * 10 + i;
                queue.add(next);
                decreasing.add(next);
            }
        }
        Collections.sort(decreasing);
        System.out.println(decreasing.get(n));
    }
}