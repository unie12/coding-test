#include <stdio.h>
#include <stdlib.h>
#define min(a,b) (((a) < (b)) ? (a) : (b))

int n, m;
int fuel = 2000;
int space[6][6], dp[6][6][3];


int main() {
    scanf("%d %d", &n, &m);
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            scanf("%d", &space[i][j]);

            dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = space[i][j];
            if(j==0) dp[i][j][0] = 1000;
            if(j==m-1) dp[i][j][2] = 1000;
        }
    }

    for(int i=1; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(j != 0)
                dp[i][j][0] += min(dp[i-1][j-1][1], dp[i-1][j-1][2]);

            dp[i][j][1] += min(dp[i-1][j][0], dp[i-1][j][2]);

            if(j != m-1)
            dp[i][j][2] += min(dp[i-1][j+1][0], dp[i-1][j+1][1]);
        }
    }

    for(int j=0; j<m; j++){
        for(int k=0; k<3; k++){
            if(fuel > dp[n-1][j][k])
                fuel = dp[n-1][j][k];
        }
    }
    printf("%d", fuel);
}