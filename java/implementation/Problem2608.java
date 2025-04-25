package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem2608 {
    static String first, second;
    static Map<Character, Integer> rules = new HashMap<>();
    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine();
        second = br.readLine();

        // 몇 번 나왔는지, 얼마나 연속적으로 나왔는지 알아야 하는데?
        // 작은 숫자가 큰 숫자 왼쪽에 오는 규칙 확인해야 함
        rules.put('I', 1);
        rules.put('V', 5);
        rules.put('X', 10);
        rules.put('L', 50);
        rules.put('C', 100);
        rules.put('D', 500);
        rules.put('M', 1000);

        // 주어진 first, second를 각각 숫자로 치환하고 더한 값 출력 + 로마 숫자로 변환
        int firstVal = exchange(first);
        int secondVal = exchange(second);
        int sum = firstVal + secondVal;

        System.out.println(sum);
        System.out.println(toRoman(sum));
    }

    public static int exchange(String word) {
        int sum = 0;

        for (int i = 0; i < word.length(); i++) {
            int currentVal = rules.get(word.charAt(i));

            if (i + 1 < word.length() && currentVal < rules.get(word.charAt(i + 1))) {
                sum -= currentVal;
            } else {
                sum += currentVal;
            }
        }
        return sum;
    }

    public static String toRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
