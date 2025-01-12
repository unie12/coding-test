package implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem20291 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> extensionMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] file = br.readLine().split("\\.");
            extensionMap.put(file[1], extensionMap.getOrDefault(file[1], 0) + 1);
        }

        List<String> extensions = new ArrayList<>(extensionMap.keySet());
        Collections.sort(extensions);
        for (String ext : extensions) {
            sb.append(ext).append(" ").append(extensionMap.get(ext)).append("\n");
        }

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
    }
}
