package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1497 {
    static long[] guitars;
    static int n, m;
    static int maxSongs = 0;
    static int minGuitars = -1;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());   

        guitars = new long[n];

        for (int i = 0 ; i < n; i ++) {
            st  = new StringTokenizer(br.readLine());
            st.nextToken();
            String songs = st.nextToken();

            for (int j = 0 ; j < m; j++) {
                if (songs.charAt(j) == 'Y') {
                    guitars[i] |= (1L << j);
                }
            }
        }

        for (int i = 1; i < (1 << n); i++) { // 2^n
            long playable = 0;
            int guitarCount = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // 기타 선택
                    playable |= guitars[j]; // 선택된 기타들 or 연산
                    guitarCount++; 
                }
            }

            int songCount = Long.bitCount(playable); // 1비트 count

            if (songCount > maxSongs) {
                maxSongs = songCount;
                minGuitars = guitarCount;
            } else if (songCount == maxSongs && guitarCount < minGuitars) {
                minGuitars = guitarCount;
            }
        }

        System.out.println(maxSongs == 0 ? -1 : minGuitars);
    }
}
