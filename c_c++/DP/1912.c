#include <stdio.h>

int n;
int sum[100001];
int max = -1001;
int arr[100001];

int main(){
    scanf("%d ", &n);
    for(int i = 0 ; i < n; i++)
        scanf("%d", &arr[i]);

    for(int i=0; i<n; i++){
        if(i>0 && (arr[i] <= (sum[i-1] + arr[i]))){
            sum[i] = sum[i-1] + arr[i];
        }
        else{
            sum[i] = arr[i];
        }
        if(sum[i] > max)
            max = sum[i];
    }
    printf("%d", max);
}