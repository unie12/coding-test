package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem3107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ipv6 = br.readLine();

        // ':'이 7개가 발견이 되야하고
        // 만약 이보다 적고 '::'이 발견이 된다면 해당 칸에서 0000을 ':'이 7개가 될 때까지 확장
        // ':' 사이사이에 문자 개수를 파악해서 0을 넣어줘야하는데

        String[] parts = ipv6.split("::", -1);
        List<String> groups = new ArrayList<>();

        if (!parts[0].isEmpty()) {
            String[] left = parts[0].split(":");
            for (String s : left) {
                groups.add(zfill(s, 4));
            }
        }

        List<String> rightGroups = new ArrayList<>();
        if (parts.length > 1 && !parts[1].isEmpty()) {
            String[] right = parts[1].split(":");
            for (String s : right) {
                rightGroups.add(zfill(s, 4));
            }
        }

        int total = groups.size() + rightGroups.size();
        int missing = 8 - total;

        for (int i = 0; i < missing; i++) {
            groups.add("0000");
        }

        groups.addAll(rightGroups);
        // System.out.println(groups);
        System.out.println(String.join(":", groups));
    }

    static String zfill(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - s.length(); i++) {
            sb.append('0');
        }
        sb.append(s);
        return sb.toString();
    }
}
