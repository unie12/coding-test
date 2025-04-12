package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2141 {
    static class Village implements Comparable<Village> {
        int position;
        int population;

        public Village(int position, int population) {
            this.position = position;
            this.population = population;
        }

        @Override
        public int compareTo(Village other) {
            return this.position - other.position;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 ~ 100,000
        Village[] villages = new Village[n];
        long totalPopulations = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int population = Integer.parseInt(st.nextToken());
            villages[i] = new Village(position, population);
            totalPopulations += population;
        }

        // 사람의 수를 고려하는게 중요함
        // 그럼 일단 사람 많은 마을로 정렬해서 해당 마을 기준으로 계속 계산?
        // 근데 이렇게 하면 계산을 너무 많이 해야하는데?
        // 1억 개의 마을에 1억 명의 사람들이 있을 수 있는데 이게 128mb로 계산이 안되지 않나
        
        Arrays.sort(villages);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += villages[i].population;

            if (sum >= (totalPopulations + 1) / 2) {
                System.out.println(villages[i].position);
                return;
            }
        }
    }
}
