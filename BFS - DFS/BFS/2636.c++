#include <stdio.h>
#include <utility>
#include <queue>
#include <iostream>
#include <cstring>

using namespace std;

int R,C ;
int plane[101][101];
int visit[101][101];
int timE, cheese; 

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

bool bfs() {
    visit[0][0] = 1;
    int cnt = 0;
    queue<pair<int ,int>> que;
    que.push({0,0});
    timE++;
    while(!que.empty()) {
        int x = que.front().first;
        int y = que.front().second;
        que.pop();

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=R || ny>=C)
                continue;
            if(visit[nx][ny] == 1)
                continue;
            if(plane[nx][ny] == 0) {
                que.push({nx, ny});
            } else {
                plane[nx][ny] = 0;
                cnt++;
            }
            visit[nx][ny] = 1;
        }
    }

    if(cnt == 0) {
        printf("%d\n", --timE);
        return true;
    }
    else {
        cheese = cnt;
        return false;
    }
}

int main() {
    scanf("%d %d", &R, &C);

    for(int i=0; i<R; i++) {
        for(int j=0; j<C; j++) {
            scanf("%d", &plane[i][j]);
        }
    }

    while(1) {
        if(bfs() == true)
            break;
        memset(visit, 0, sizeof(visit));
    }
    printf("%d", cheese);
}
