import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem1043 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        if (truth == 0) {
            System.out.println(m);
            return;
        }

        int firstTruthPerson = Integer.parseInt(st.nextToken());
        for (int i = 1; i < truth; i++) {
            union(firstTruthPerson, Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer>[] parties = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());

            if (partySize > 0) {
                int firstPerson = Integer.parseInt(st.nextToken());
                parties[i].add(firstPerson);

                for (int j = 1; j < partySize; j++) {
                    int person = Integer.parseInt(st.nextToken());
                    parties[i].add(person);
                    union(firstPerson, person);
                }
            }
        }

        int answer = 0;
        for (ArrayList<Integer> party : parties) {
            if (party.size() > 0) {
                if (!isConnectedToTruth(party.get(0), firstTruthPerson)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    static boolean isConnectedToTruth(int person, int truthPerson) {
        return find(person) == find(truthPerson);
    }
}
