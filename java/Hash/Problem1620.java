package Hash;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem1620 {
    public static void main(String[] args) throws IOException{
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> pokemons = new HashMap<>();
        HashMap<Integer, String> intPokemons = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String pokemon = br.readLine();
            pokemons.put(pokemon, i);
            intPokemons.put(i, pokemon);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String problem = br.readLine();
            if (Character.isDigit(problem.charAt(0))) {
                int indx = Integer.parseInt(problem);
                sb.append(intPokemons.get(indx - 1)).append('\n');
            } else {
                sb.append(pokemons.get(problem) + 1).append('\n');
            }
        }
        System.out.println(sb);
        
    }
}
