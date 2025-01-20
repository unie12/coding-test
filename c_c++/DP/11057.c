#include <stdio.h>

int n;
long long dp[1001][10];
long long result;

int main() {
    scanf("%d", &n);

    for(int i=0; i<=9; i++)
        dp[1][i] = 1;
    
    for(int i=2; i<=n; i++) {
        for(int j=0; j<=9; j++) {
            for(int k=0; k<=j; k++) {
                dp[i][j] += dp[i-1][k];
                dp[i][j] %= 10007;
                // printf("dp[%d][%d] = %d\n", i,j,dp[i][j]);
            }   
        }
    }
    for(int i=0; i<=9; i++) {
        result += dp[n][i];
    }
    printf("%d", result%10007);
}
