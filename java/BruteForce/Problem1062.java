package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1062 {
    /**
     * BackTracking 방식
     */
    // static int n, k;
    // static String[] words;
    // static boolean[] learned = new boolean[26];
    // static int max = 0;
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());

    //     n = Integer.parseInt(st.nextToken()); // 글자 목록 ~50
    //     k = Integer.parseInt(st.nextToken());// 읽을 수 있는 글자 수 ~ 26 

    //     if (k < 5) {
    //         System.out.println(0);
    //         return;
    //     }

    //     if (k == 26) {
    //         System.out.println(n);
    //         return;
    //     }

    //     // anta ~ tica = 최소 5개 이상이어야 읽을 수 있음 -> 4개 이하면 0 확정
    //     // 일단 a, n, t, i, c에 대해 읽을 수 있다고 정해놓고 어떤 글자를 추가적으로 읽을지 정해야 함
    //     // 글자별로 어떤 알파벳을 사용하는지 확인을 하고 가장 많이 사용되는 알파벳 선정

    //     words = new String[n];
    //     learned = new boolean[26];
    //     learned['a' - 'a'] = true;
    //     learned['c' - 'a'] = true;
    //     learned['n' - 'a'] = true;
    //     learned['t' - 'a'] = true;
    //     learned['i' - 'a'] = true;

    //     for (int i = 0; i < n; i++) {
    //         words[i] = br.readLine();
    //     }

    //     backtrack(0, 5);
    //     System.out.println(max);
    // }

    // static void backtrack(int start, int count) {
    //     if (count == k) {
    //         int readable = 0;
    //         for (String word : words) {
    //             boolean canRead = true;
    //             for (int i = 0; i < word.length(); i++) {
    //                 if (!learned[word.charAt(i) - 'a']) {
    //                     canRead = false;
    //                     break;
    //                 }
    //             }
    //             if (canRead) readable++;
    //         }
    //         max = Math.max(max, readable);
    //         return;
    //     }

    //     for (int i = start; i < 26; i++) {
    //         if (!learned[i]) {
    //             learned[i] = true;
    //             backtrack(i + 1, count + 1);
    //             learned[i] = false;
    //         }
    //     }
    // }

    /**
     * 비트마스크 방식
     */
    static int n, k;
    static int[] words;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 글자 목록 ~50
        k = Integer.parseInt(st.nextToken());// 읽을 수 있는 글자 수 ~ 26 

        if (k < 5) {
            System.out.println(0);
            return;
        }

        if (k == 26) {
            System.out.println(n);
            return;
        }

        // 각 단어를 비트마스크로 표현한다..
        words = new int[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int bit = 0;
            for (int j = 0; j < word.length(); j++) {
                bit |= (1 << (word.charAt(j) - 'a'));
            }
            words[i] = bit;
        }

        int learned = 0;
        learned |= (1 << ('a'- 'a'));
        learned |= (1 << ('n'- 'a'));
        learned |= (1 << ('t'- 'a'));
        learned |= (1 << ('i'- 'a'));
        learned |= (1 << ('c'- 'a'));

        dfs(0, 5, learned);
        System.out.println(max);
    }

    static void dfs(int idx, int count, int learned) {
        if (count == k || idx == 26) {
            int readable = 0;
            for (int word : words) {
                if ((word & ~ learned) == 0) {
                    readable++;
                }
            }

            max = Math.max(max, readable);
            return;
        }

        // 현재 알파벳을 이미 배웠으면 건너뜀
        if ((learned & (1 << idx)) != 0) {
            dfs(idx + 1, count, learned);
            return;
        }

        // 현재 알파벳을 배우는 경우
        dfs(idx + 1, count + 1, learned | (1 << idx));

        // 현재 알파벳을 배우지 않는 경우
        dfs(idx + 1, count, learned);
    }
}
