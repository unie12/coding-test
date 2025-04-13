package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem32978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> ingredients = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n; i++) {
            ingredients.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            String ingredient = st.nextToken();
            ingredients.remove(ingredient);
        }

        System.out.println(ingredients.iterator().next());
        
    }
}
