#include <stdio.h>
#include <stdlib.h>
#define max(a,b) (((a) > (b)) ? (a) : (b))

int t, n;

int main() {
    scanf("%d", &t);
    for(int T=0; T<t; T++) {
        int value[2][100001];
        int dp[2][100001];
        int max = 0;
        scanf("%d", &n);

        for(int k = 0; k<2; k++) 
            for(int N = 1; N<=n; N++) 
                scanf("%d", &value[k][N]);

        dp[0][0] = dp[1][0] = 0;
        dp[0][1] = value[0][1];
        dp[1][1] = value[1][1];

        for(int i=2; i<=n; i++) {
            dp[0][i] = max(dp[1][i-2], dp[1][i-1]) + value[0][i];
            dp[1][i] = max(dp[0][i-2], dp[0][i-1]) + value[1][i];
        }
        printf("%d\n", max(dp[0][n], dp[1][n]));
    }

}