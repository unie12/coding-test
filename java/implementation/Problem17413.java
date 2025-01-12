package implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem17413 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean inTag = false;

        for (char c : input.toCharArray()) {
            if (c == '<') {
                inTag = true;
                result.append(word.reverse());
                word.setLength(0);
                result.append(c);
            } else if (c == '>') {
                inTag = false;
                result.append(c);
            } else if (inTag) {
                result.append(c);
            } else if (c == ' ') {
                result.append(word.reverse());
                word.setLength(0);
                result.append(c);
            } else {
                word.append(c);
            }
        }
        result.append(word.reverse());
        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
}
