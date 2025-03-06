package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxHeight = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            map.put(l, h);
            maxHeight = Math.max(maxHeight, h);
        }
        
        int result = 0;
        int leftMaxL = -1, rightMaxL = -1;
        int prevL = map.firstKey();
        int prevH = map.get(prevL);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxHeight && leftMaxL == -1) {
                leftMaxL = entry.getKey();
            }

            if (entry.getValue() > prevH) {
                result += (entry.getKey() - prevL) * prevH;
                prevL = entry.getKey();
                prevH = entry.getValue();
            }
        }

        prevL = map.lastKey();
        prevH = map.get(prevL);

        for (Map.Entry<Integer, Integer> entry : map.descendingMap().entrySet()) {
            if (entry.getValue() > prevH) {
                result += (prevL - entry.getKey()) * prevH;
                prevL = entry.getKey();
                prevH = entry.getValue();
            }

            if (entry.getValue() == maxHeight && rightMaxL == -1) {
                rightMaxL = entry.getKey();
                break;
            }
        }

        result += ((rightMaxL - leftMaxL + 1) * maxHeight);
        System.out.println(result);
    }
}