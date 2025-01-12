package String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashSet<String> pset = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pset.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if(pset.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
    
}
