package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1744 {
    static int n;
    static List<Integer> positive = new ArrayList<>();
    static List<Integer> negative = new ArrayList<>();
    static int zeroCount = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > 0) {
                positive.add(value);
            } else if (value < 0) {
                negative.add(value);
            } else {
                zeroCount++;
            }
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);


        // 정렬 후, 가장 큰 수끼리 곱하는건 무조건이지 않나?
        // 그리고 곱하고 나서 더한 값보다 곱한 값이 크면 묶고
        // 만약 한 쪽 이상이 음수라면 음수끼리 곱셈하되, 절대값이 큰 음수끼리 곱셈
        // 만약 음수가 하나라면 더하기
        // 0이 존재함 -> 음수가 하나일 때 곱하기 사용 or 음수가 없다면 더하기로 처리

        for (int i = 0; i < positive.size(); i++) {
            if (i == positive.size() - 1 || positive.get(i) == 1 || positive.get(i + 1) == 1) {
                result += positive.get(i);
            } else {
                result += positive.get(i) * positive.get(i + 1);
                i++;
            }
        }
        
        for (int i = 0; i < negative.size(); i++) {
            if (i == negative.size() - 1) {
                // 음수가 홀수일 경우 -> 0 있나 확인 후 가장 작은 값 0이랑 곱하기, 없으면 그냥 더하기
                if (zeroCount > 0) {

                } else {
                    result += negative.get(i);
                }
            } else {
                result += negative.get(i) * negative.get(i + 1);
                i++;
            }
        }
        
        System.out.println(result);
    }
}
