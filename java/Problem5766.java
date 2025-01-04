import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem5766 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            Map<Integer, Integer> scores = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int player = Integer.parseInt(st.nextToken());
                    scores.put(player, scores.getOrDefault(player, 0) + 1);
                }
            }

            List<Integer> players = new ArrayList<>(scores.keySet());
            players.sort((a,b) -> {
                int scoreCompare = scores.get(b).compareTo(scores.get(a));
                if (scoreCompare == 0) return a.compareTo(b);
                return scoreCompare;
            });

            int secondScore = scores.get(players.get(1));

            StringBuilder sb = new StringBuilder();
            for (int player : players) {
                if (scores.get(player) == secondScore) {
                    sb.append(player).append(" ");
                }
            }
            bw.write(sb.toString().trim() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
