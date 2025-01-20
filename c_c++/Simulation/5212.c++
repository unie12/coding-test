#include <stdio.h>
#include <queue>
#include <utility>
#include <vector>
#include <algorithm>

using namespace std;

int R, C;
char map[11][11];
int result[11][11];
char tmp[11][11];

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

queue<pair<int, int>> que;

int main() {
    scanf("%d %d", &R, &C);
    getchar();

    for(int i=0; i<R; i++) {
        for(int j=0; j<C; j++) {
            scanf("%c", &map[i][j]);
            if(map[i][j] == 'X') {
                que.push({i, j});
                result[i][j] = 1;
            }
        }
        getchar();
    }

    while(!que.empty()) {
        pair<int, int> tmpQue = que.front();
        que.pop();

        int x = tmpQue.first;
        int y = tmpQue.second;
        int water = 0;

        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || ny < 0 || nx>=R || ny>=C || map[nx][ny] == '.') {
                water++;
            }
        }
        if(water >= 3) {
            // printf("nx: %d ny: %d\n", x, y);

            result[x][y] = 0;
        }
    }

    int minX = R, minY = C, maxX = 0, maxY = 0;
    for(int i=0; i<R; i++) {
        for(int j=0; j<C; j++) {
            if(result[i][j] == 1) {
                if(i < minX) minX = i;
                if(i > maxX) maxX = i;
                if(j < minY) minY = j;
                if(j > maxY) maxY = j;
            }
        }
    }

    // 최종 결과 출력
    for(int i=minX; i<=maxX; i++) {
        for(int j=minY; j<=maxY; j++) {
            if(result[i][j] == 1)
                printf("X");
            else
                printf(".");
        }
        printf("\n");
    }
    


}