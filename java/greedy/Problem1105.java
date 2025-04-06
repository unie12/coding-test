package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// public class Problem1105 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int L = Integer.parseInt(st.nextToken());
//         int R = Integer.parseInt(st.nextToken());

//         int count = Integer.MAX_VALUE;


//         while (L <= R) {
//             if (count == 0) {
//                 break;
//             }

//             int eight = 0;
//             // L 숫자에서 8추출 어떻게?
//             int tmp = L;
//             while (tmp > 0) {
//                 if (tmp % 10 == 8) {
//                     eight++;
//                 }
//                 tmp /= 10;
//             }
            
            
//             count = Math.min(eight, count);
//             L++;
//         }
//         System.out.println(count);
        
//     }
// }

public class Problem1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();

        int count = 0;

        if (L.length() != R.length()) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < L.length(); i++) {
            if (L.charAt(i) == R.charAt(i)) {
                if (L.charAt(i) == '8') {
                    count++;
                }
            } else {
                break;
            }
        }

        System.out.println(count);
        
    }
}