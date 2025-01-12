package implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Problem1283 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Character> usedShortcuts = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String option = br.readLine();
            String[] words = option.split(" ");
            boolean found = false;

            for (int j = 0; j < words.length && !found; j++) {
                char firstChar = words[j].charAt(0);
                if (!usedShortcuts.contains(Character.toLowerCase(firstChar)) &&
                    !usedShortcuts.contains(Character.toUpperCase(firstChar))) {
                        usedShortcuts.add(Character.toLowerCase(firstChar));
                        usedShortcuts.add(Character.toUpperCase(firstChar));
                        words[j] = "[" + firstChar + "]" + words[j].substring(1);
                        found = true;
                }
            }

            if (!found) {
                boolean shortcurSet = false;

                for (int j=0; j<words.length && !shortcurSet; j++) {
                    for (int k = 0; k < words[j].length() && !shortcurSet; k++) {
                        char c = words[j].charAt(k);
                        if (!usedShortcuts.contains(Character.toLowerCase(c)) &&
                        !usedShortcuts.contains(Character.toUpperCase(c))) {
                            usedShortcuts.add(Character.toLowerCase(c));
                            usedShortcuts.add(Character.toUpperCase(c));
                            words[j] =  words[j].substring(0, k) + "[" + c + "]" + words[j].substring(k + 1);
                            shortcurSet = true;
                        }
                    }
                }
            }
            bw.write(String.join(" ", words) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }    
}
