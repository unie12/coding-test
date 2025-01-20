#include <stdio.h>
#include <vector>
#include <queue>
#include <algorithm>
#include <string>

using namespace std;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int n, m;
int map[8][8];
int visit[8][8];
int ans;

void spread() {
    int spreadMap[8][8];
    queue<pair<int, int>> q;
    int cnt = 0;

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++){
            spreadMap[i][j] = visit[i][j];
            if(spreadMap[i][j] == 2)
                q.push({i,j});
        }
    }

    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];

            if(nx<0 || ny<0 || nx>=n || ny>=m)
                continue;
            if(spreadMap[nx][ny] == 0) {
                spreadMap[nx][ny] = 2;
                q.push({nx, ny});
            }
        }
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(spreadMap[i][j] == 0) 
                cnt++;
        }
    }
    ans = max(ans, cnt);
}

void wall(int cur) {
    if(cur == 3) {
        spread();
        return;
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(visit[i][j] == 0) {
                visit[i][j] = 1;
                wall(cur+1);
                visit[i][j] = 0;
            }
        }
    }
}

int main() {
    scanf("%d %d", &n ,&m);
    int a, b;
    for(int i = 0; i<n; i++) {
        for(int j=0; j<m; j++)  {
            scanf("%d", &map[i][j]);
            visit[i][j] = map[i][j];
        }
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(map[i][j] == 0) {
                visit[i][j] = 1;
                wall(1);
                visit[i][j] = 0;
            }
        }
    }
    
    printf("%d", ans);
}