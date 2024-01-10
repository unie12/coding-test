#include <stdio.h>

int n;
int dp[17][17];
int house[17][17];

int dx[4] = {1, 0, 1, 0};
int dy[4] = {0, 1, 0, 1};

typedef struct 
{
    int x;
    int y;
}Que;

Que que[17][17];
int front, rera;

void dfs() {

}

int main() {
    scanf("%d", &n);


    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            scanf("%d", &house[i][j]);
        }
    }

}