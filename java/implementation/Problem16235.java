package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16235 {
    static int n, m, k;
    static int[][] lands;
    static int[][] a;
    static PriorityQueue<Integer>[][] treeMap;
    static List<int[]> deadTrees;
    static int alivaeTree = 0;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Tree {
        int x;
        int y;
        int z;

        Tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 1 ~ 10 // n * n 크기의 땅
        m = Integer.parseInt(st.nextToken()); // 1 ~ n^2 (max 100) // 심은 나무의 정보
        k = Integer.parseInt(st.nextToken()); // 1 ~ 1000

        lands = new int[n + 1][n + 1];
        a = new int[n + 1][n + 1];
        treeMap = new PriorityQueue[n + 1][n + 1];
        alivaeTree = m;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                treeMap[i][j] = new PriorityQueue<>();
            }
        }

        /**
         * 1. 가장 처음에 모든 칸에 5만큼의 양분이 존재
         * 2. 나무 재테크 - 1 x 1 크기의 칸에 여러 개의 나무가 심어질 수 있음
         *  2.1 봄: 자신의 나이만큼 양분을 먹고 나이 1 증가 
         *      2.1.1 하나의 칸에 여러 개의 나무가 존재한다면 어린 나무부터
         *      2.1.2 양분이 부족하다면 바로 사망
         *  2.2 여름: 죽은 나무가 양분으로 변함. (나이 / 2)만큼 양분 추가
         *  2.3 가을: 나무 번식
         *      2.3.1 나이가 5의 배수여야 번식 가능
         *      2.3.2 인접한 8개의 칸에 나이가 1인 나무가 생김
         *  2.4 겨울: 땅에 양분 추가 (A[r][c]만큼)
        */

        
        // 1. 5의 양분 추가
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                lands[i][j] = 5;
            }
        }

        // 각 칸에 추가되는 양분의 양
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 나무의 위치 (x, y) 나무의 나이 z
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            treeMap[x][y].add(z);
        }
        
        int year = 0;
        while (year < k) {
            // trees를 z 기준으로 sort한 다음에 진행해야 함
            spring();
            fall();
            winter();
            year++;
        }

        System.out.println(alivaeTree);

    }

    static private void spring() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Queue<Integer> survived = new LinkedList<>();
                int deadNutrient = 0;
                
                while (!treeMap[i][j].isEmpty()) {
                    int age = treeMap[i][j].poll();

                    if (lands[i][j] >= age) {
                        lands[i][j] -= age;
                        survived.add(age + 1);
                    } else {
                        deadNutrient += age / 2; 
                        alivaeTree--;
                    }
                }

                while (!survived.isEmpty()) {
                    treeMap[i][j].add(survived.poll());
                }
                
                lands[i][j] += deadNutrient;
            }
        }
    }

    static private void fall() {
        List<int[]> breedingTrees = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Queue<Integer> temp = new LinkedList<>();
                while (!treeMap[i][j].isEmpty()) {
                    int age = treeMap[i][j].poll();
                    temp.add(age);

                    if (age % 5 == 0) {
                        breedingTrees.add(new int[]{i, j});
                    }
                }

                while (!temp.isEmpty()) {
                    treeMap[i][j].add(temp.poll());
                }
            }
        }

        for (int[] tree : breedingTrees) {
            int x = tree[0];
            int y = tree[1];

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                    treeMap[nx][ny].add(1);
                    alivaeTree++;
                }
            }
        }
    }

    static private void winter() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                lands[i][j] += a[i][j];
            }
        }
    }
}
