#include <stdio.h>
#include <math.h>

int n;
int cnt;
int dp[100001];

int main(){
    scanf("%d", &n);
    for(int i=1; i<=n; i++)
        dp[i] = i;

    for(int i=1; i<=n; i++){
        for(int j=1; j*j<=i; j++){
            if(dp[i] > (dp[i - j*j] + 1))
                dp[i] = dp[i - j*j] + 1;
            // printf("ival: %d jval: %d dp[%d] = %d\n", i, j, i, dp[i]);

        }
    }
    printf("%d", dp[n]);
}