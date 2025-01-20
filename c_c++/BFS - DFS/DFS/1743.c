#include <stdio.h>

int n, m, k; // 세로, 가로, 쓰레기 개수
int sum = 1;
int passage[102][102]; // 통로
int visit[102][102];
int dx[4] = {1, 0 , -1, 0};
int dy[4] = {0, 1, 0, -1};
int max = -1;

// dfs
void dfs(int r, int x){
    visit[r][x] = 1;
    sum++;

    for(int i=0; i<4; i++){
        int nx = r + dx[i]; 
        int ny = x + dy[i];
        if(nx <0 || ny <0 || nx>n || ny>m)
            continue;
        if(visit[nx][ny] !=0 || passage[nx][ny] != 1)
            continue;
        dfs(nx, ny);
    }
}

int main(void){
    scanf("%d %d %d", &n, &m, &k);
    
    int x, y;
    for(int i=0; i<k; i++){
        scanf("%d %d", &x, &y);
        passage[x][y] = 1;
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            if(passage[i][j] == 1 && visit[i][j] == 0){
                sum = 0;
                dfs(i,j);
                if(sum > max)
                    max = sum;
            }
        }
    }
    printf("%d", max);
    return 0;
}
