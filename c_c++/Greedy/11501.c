#include <stdio.h>
#include <stdlib.h>

int T, N;
int price[1000001];

int main(){
    scanf("%d", &T);
    
    for(int i=0; i<T; i++){
        scanf("%d" ,&N);

        for(int j=0; j<N; j++){
            scanf("%d", &price[j]);
        }

        long long result = 0;
        int maxPrice = price[N - 1];

        for(int j=N-2; j>=0; j--){
            if(price[j] > maxPrice){
                maxPrice = price[j];
            } else {
                result += maxPrice - price[j];
            }
        }

        printf("%lld\n", result);
    }

    return 0;
}