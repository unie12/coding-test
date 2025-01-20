#include <stdio.h>

int n, k;
long long dp[1001][1001];

int main() {
    scanf("%d %d", &n, &k);
    dp[1][1] = dp[0][0] = dp[1][0] = 1;

    for(int i=2; i<=n; i++) {
        for(int j=0; j<=i; j++) {
            if(i == j || j == 0)
                dp[i][j] = 1;
            else{
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                dp[i][j] %= 10007;
            }
            // printf("dp[%d][%d] = %d\n", i, j, dp[i][j]);
        }
    }
    printf("%lld", dp[n][k]);
}