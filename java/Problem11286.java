import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> absHeap = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            
            if (absA == absB) {
                return a - b;
            }
            return absA - absB;
        });
        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (absHeap.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(absHeap.poll()).append('\n');
                }
            } else {
                absHeap.offer(input);
            }
        }
        System.out.println(sb);
    }
}
