#include <stdio.h>
#include <stdlib.h>

int T, N;
int price[1000001];
long long sum;
int max = -1;
int maxIndex, startIndex;

void Greedy(int start, int index, long long val){
    // printf("infor: %d %d %lld\n", start, index, val);
    for(int j=start; j<index; j++){
        if(price[j] < val)
            sum = sum + price[index] - price[j];
    }
    if(index+1 < N){
        val = -1;
        start = index+1;
        for(int i=index+1; i<N; i++){
            if(price[i] > val){
                val = price[i];
                index = i;
            }
        }
        Greedy(start, index, val);
    }
}

int main(){
    scanf("%d", &T);
    
    for(int i=0; i<T; i++){
        sum = max = maxIndex = startIndex = 0;
        scanf("%d" ,&N);

        for(int j=0; j<N; j++){
            scanf("%d", &price[j]);
            if(price[j] > max){
                max = price[j];
                maxIndex = j;
            }
        }
        Greedy(startIndex, maxIndex, max);
        printf("%lld\n", sum);
    }

    return 0;
}