#include <stdio.h>
#include <stdlib.h>
#define max(a,b) (((a) > (b)) ? (a) : (b))

int n, max;
int p[1001];
int dp[1001];

int main() {
    scanf("%d", &n);
    for(int i=1; i<=n; i++)
        scanf("%d", &p[i]);

    for(int i=1; i<=n; i++ ) {
        for(int j=1; j<=i; j++) {
            dp[i] = max(dp[i-j] + p[j], dp[i]);
        }
    }       
    printf("%d", dp[n]);
}