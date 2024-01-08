#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#define max(a,b) (((a) > (b)) ? (a) : (b))

int n;
int arr[1001];
int max;
int dp[1001];

int main() {
    scanf("%d", &n);

    for(int i=1; i<=n; i++)  {
        scanf("%d", &arr[i]);
    }

    for(int i=1; i<=n; i++) {
        dp[i] = arr[i];

        for(int j=1; j<i; j++) {
            if(arr[j] < arr[i] && (dp[i] < dp[j] + arr[i])){
                dp[i] = dp[j] + arr[i];
                // printf("dp[%d] = dp[%d] + arr[%d] = %d + %d = %d\n",i,j,i,dp[j],arr[i], dp[i]);
            }
        }
        if(max < dp[i])
            max = dp[i];
    }


    printf("%d" ,max);

}