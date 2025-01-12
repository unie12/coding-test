package implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Problem20436 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, int[]> keyboard = new HashMap<>();
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                keyboard.put(rows[i].charAt(j), new int[]{i, j});
            }
        }

        String[] initialPositions = br.readLine().split(" ");
        char leftHand = initialPositions[0].charAt(0);
        char rightHand = initialPositions[1].charAt(0);

        String input = br.readLine();

        int[] leftPos = keyboard.get(leftHand);
        int[] rightPos = keyboard.get(rightHand);

        int totalTime = 0;

        for (char c : input.toCharArray()) {
            int[] targetPos = keyboard.get(c);

            if (isLeftHand(c)) {
                totalTime += caculateDistance(leftPos, targetPos) + 1;
                leftPos = targetPos;
            } else {
                totalTime += caculateDistance(rightPos, targetPos) + 1;
                rightPos = targetPos;
            }
        }
        bw.write(totalTime + "\n");

        bw.flush();
        bw.close();
    }
    
    private static boolean isLeftHand(char c) {
        String leftkeys = "qwertasdfgzxcv";
        return leftkeys.indexOf(c) != -1;
    }

    private static int caculateDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
}
