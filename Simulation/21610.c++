#include <stdio.h>
#include <iostream>
#include <queue>
#include <utility>

using namespace std;
int n, m; // 
int A[51][51]; // 바구니
int visit[51][51];
int d, s; // 이동 정보
queue<pair<int, int>> q;

int dx[9] = {99,-1, -1, 0, 1, 1, 1, 0, -1};
int dy[9] = {99, 0, -1, -1, -1, 0, 1, 1, 1};
int cloud;

int main() {
    scanf("%d %d", &n, &m);

    for(int i=1; i<=n; i++ ) {
        for(int j=1; j<=n; j++) {
            scanf("%d", &A[i][j]);
        }
    }
    q.push({n, 1});
    q.push({n, 2});
    q.push({n-1, 1});
    q.push({n-1, 2});

    while(m--) {
        scanf("%d %d", &d, &s);
        int size = q.size();
        // printf("first queue size : %d\n", size);

        // move
        for(int i=0; i<size; i++) {
            int r = q.front().first;
            int c = q.front().second;
            q.pop();

            for(int j=0; j<s; j++) {
                r += dy[d];
                c += dx[d];

                if(r < 1) r = n;
                if(r > n) r = 1;
                if(c < 1) c = n;
                if(c > n) c = 1;
            }
            // rain
            A[r][c]++;
            visit[r][c] = 1;
            q.push({r, c});
        }
        // printf("After move queue size : %d\n", q.size());

        // bug
        for(int i=0; i<size; i++) {
            int r = q.front().first;
            int c = q.front().second;
            q.pop();

            for(int j=2; j<=8; j +=2) {
                int nr = r + dy[j];
                int nc = c + dx[j];

                if(nr <= n && nc <=n && nr >= 1 && nc >= 1 && A[nr][nc]) 
                    A[r][c]++;
            }
            q.push({r,c});
        }
        // printf("After bug queue size : %d\n", q.size());


        // printf("\n");
        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=n; j++) {
        //         printf("%d ", A[i][j]);
        //     }
        //     printf("\n");
        // }
        // printf("\n");

        // make cloud
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(A[i][j] >= 2 && !visit[i][j]) {
                    q.push({i, j});
                    A[i][j] -= 2;
                }
            }
        }
        // printf("After make queue size : %d\n", q.size());

        for(int i=0; i<size; i++) {
            int tmpR = q.front().first;
            int tmpC=  q.front().second;
            visit[tmpR][tmpC] = 0;
            q.pop();
        }
        // printf("After remove previous queue size : %d\n", q.size());

    }
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            if(A[i][j] > 0)
                cloud += A[i][j];
        }
    }

    printf("%d", cloud);
}