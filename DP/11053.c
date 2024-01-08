#include <stdio.h>
#define max(a,b) (((a) > (b)) ? (a) : (b))

int n;
int arr[1001];
int dp[1001];
int max1;

int main() {
    scanf("%d", &n);

    for(int i=1; i<=n; i++) {
        scanf("%d", &arr[i]);
        dp[i] = 1;
    }

    for(int i=1; i<=n; i++) {
        for(int j=1; j<i; j++) {
            if(arr[j] < arr[i]){
                dp[i] = max(dp[i], dp[j] + 1);
                // printf("dp[%d] = max(dp[%d], dp[%d] + 1) = max(%d, %d + %d) = %d\n", i,i,j,dp[i], dp[j], 1, dp[i]);
            }
        }
        if(dp[i] > max1)
            max1 = dp[i];

    }
    printf("%d", max1);
}