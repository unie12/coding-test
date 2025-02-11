package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int c = 0; c < t; c++) {
            TreeMap<Long, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                long num = Long.parseLong(st.nextToken());

                if (op.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (!map.isEmpty()) {
                        long key = num == 1 ? map.lastKey() : map.firstKey();
                        int count = map.get(key);

                        if (count == 1) {
                            map.remove(key);
                        } else {
                            map.put(key, count - 1);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        System.out.println(sb);
    }
}
/**
 * 방법 1

public class Problem7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int c = 0; c < t; c++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> minQueue = new PriorityQueue<>();
            PriorityQueue<Long> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            Map<Long, Integer> countMap = new HashMap<>();

            for (int i = 0; i < k; i++) {
                 StringTokenizer st = new StringTokenizer(br.readLine());
                 String operation = st.nextToken();
                 long value = Long.parseLong(st.nextToken());

                 if (operation.equals("I")) {
                    minQueue.offer(value);
                    maxQueue.offer(value);
                    countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                 } else {
                    if (!countMap.isEmpty()) {
                        if (value == 1) {
                            removePQ(maxQueue, countMap);
                        } else {
                            removePQ(minQueue, countMap);
                        }
                    }
                }
            }
            cleanQueue(minQueue, maxQueue, countMap);

            if (countMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxQueue.peek() + " " + minQueue.peek() + "\n");
            }
        }
        System.out.println(sb);
    }

    private static void removePQ(PriorityQueue<Long> maxQueue, Map<Long, Integer> countMap) {
        while (!maxQueue.isEmpty()) {
            long num = maxQueue.poll();
            if (countMap.containsKey(num)) {
                if (countMap.get(num) == 1) {
                    countMap.remove(num);
                } else {
                    countMap.put(num, countMap.get(num) - 1);
                }
                break;
            }
        }
    }

    private static void cleanQueue(PriorityQueue<Long> minQueue, PriorityQueue<Long> maxQueue, Map<Long, Integer> countMap) {
        PriorityQueue<Long> newMinQueue = new PriorityQueue<>();
        PriorityQueue<Long> newMaxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (Long num : countMap.keySet()) {
            for (int i = 0; i < countMap.get(num); i++) {
                newMaxQueue.offer(num);
                newMinQueue.offer(num);
            }
        }

        minQueue.clear();
        maxQueue.clear();
        minQueue.addAll(newMinQueue);
        maxQueue.addAll(newMaxQueue);
    }
}
*/


/**
 * 방법 2

public class Problem7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int c = 0; c < t; c++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> minQueue = new PriorityQueue<>();
            PriorityQueue<Long> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            Map<Long, Integer> countMap = new HashMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                long value = Long.parseLong(st.nextToken());

                if (operation.equals("I")) {
                    minQueue.offer(value);
                    maxQueue.offer(value);
                    countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                } else {
                    if (!countMap.isEmpty()) {
                        removeNumber(value == 1 ? maxQueue : minQueue, countMap);
                    }
                }
            }

            if (countMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                // 유효한 최대값 찾기
                while (!maxQueue.isEmpty() && !countMap.containsKey(maxQueue.peek())) {
                    maxQueue.poll();
                }
                // 유효한 최소값 찾기
                while (!minQueue.isEmpty() && !countMap.containsKey(minQueue.peek())) {
                    minQueue.poll();
                }
                sb.append(maxQueue.peek() + " " + minQueue.peek() + "\n");
            }
        }
        System.out.println(sb);
    }

    private static void removeNumber(PriorityQueue<Long> queue, Map<Long, Integer> countMap) {
        while (!queue.isEmpty()) {
            long num = queue.poll();
            if (countMap.containsKey(num)) {
                if (countMap.get(num) == 1) {
                    countMap.remove(num);
                } else {
                    countMap.put(num, countMap.get(num) - 1);
                }
                break;
            }
        }
    }
}
*/