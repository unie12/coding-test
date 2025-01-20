#include <stdio.h>
#include <stdlib.h>

#define max(a,b) ((a) > (b) ? (a) : (b))

int n,k;
int value[101];
long long dp[10001];

int main() {
    scanf("%d %d", &n,&k);

    for(int i=1; i<=n; i++) {
        scanf("%d", &value[i]);
    }
    dp[0] = 1;
    
    for(int i=1; i<=n; i++) {
        for(int j=value[i]; j<=k; j++) {
            dp[j] += dp[j - value[i]];
        }
    }
    printf("%lld", dp[k]);
}