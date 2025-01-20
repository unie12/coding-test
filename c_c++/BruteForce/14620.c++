#include <stdio.h>

int board[11][11];
int visit[11][11];
int n, answer, min = 200 * 5 * 3;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void solution(int seed, int cost) {
    if(seed == 3) {
        if(min > cost)
            min = cost;
        // printf("cost: %d\n", cost);
        return;
    }
    
    for(int i=2; i<n; i++) {
        for(int j=2; j<n; j++) {
            if(i-1 < 1 || i+1 > n || j-1 < 1 || j+1 > n)
                continue;
            if(visit[i-1][j] !=0 || visit[i+1][j] !=0 || visit[i][j-1] != 0 || visit[i][j+1] !=0 || visit[i][j] != 0)
                continue;
            seed++;
            cost += board[i][j] + board[i-1][j] + board[i+1][j] + board[i][j+1] + board[i][j-1];
            visit[i-1][j] = visit[i+1][j] = visit[i][j-1] = visit[i][j+1] = visit[i][j] = 1;
            
            solution(seed,cost);

            seed--;
            cost -= board[i][j] + board[i-1][j] + board[i+1][j] + board[i][j+1] + board[i][j-1];
            visit[i-1][j] = visit[i+1][j] = visit[i][j-1] = visit[i][j+1] = visit[i][j] = 0;
        }
    }
    
}

int main() {
    scanf("%d", &n);
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            scanf("%d", &board[i][j]);
        }
    }
    solution(0, 0);
    printf("%d", min);
}