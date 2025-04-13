package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem32979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 ~ 40
        int t = Integer.parseInt(br.readLine()); // 1 ~ 5000
        // Queue<Integer> apt = new LinkedList<>();
        // StringTokenizer st = new StringTokenizer(br.readLine());

        // for (int i = 0; i < 2 * n; i++) {
        //     apt.offer(Integer.parseInt(st.nextToken()));
        // }

        // st = new StringTokenizer(br.readLine());
        // for (int i = 0; i < t; i++) {
        //     int position = Integer.parseInt(st.nextToken());
        //     for (int j = 0; j < position - 1; j++) {
        //         apt.offer(apt.poll());
        //     }
        //     System.out.print(apt.peek() + " ");
        // }

        int[] aprtments = new int[2 * n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2 * n; i++) {
            aprtments[i] = Integer.parseInt(st.nextToken());
        }

        int currentIdx = 0;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < t; i++) {
            int position = Integer.parseInt(st.nextToken());
            currentIdx = (currentIdx + position - 1) % (2 * n);
            sb.append(aprtments[currentIdx]).append(" ");
        }
        System.out.println(sb);
    }
}
