#include <stdio.h>

int n;
int dp[1000001];

int main(){
    scanf("%d", &n);
    dp[1] = 0;

    for(int i = 2; i <= n; i++ ){
        dp[i] = dp[i-1] + 1;

        if(i % 3 == 0){
            if(dp[i] > dp[i/3])
                dp[i] = dp[i/3] + 1;
        }
        if(i % 2 == 0) {
            if(dp[i] > dp[i/2])
                dp[i] = dp[i/2] + 1;
        }
    }
    printf("%d\n", dp[n]);

    for(int i=n; i>0; i--){
        printf("%d ", i);
        if(i%2 == 0 && dp[i] == (dp[i/2] + 1)){
            i /= 2;
            i++;
        }
        else if(i%3 == 0 && dp[i] == (dp[i/3] + 1)){
            i /= 3;
            i++;
        }
    }
    return 0;
}