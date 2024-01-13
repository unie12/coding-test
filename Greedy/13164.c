#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int n, k;
int arr[300001];
int differ[300001];

int compare(void const* a, void const* b) {
    if(*(int*)a > *(int*)b)
        return 1;
    else if(*(int*)a < *(int*)b)
        return -1;
    else
        return 0;
}

int main() {
    scanf("%d %d",&n,&k);

    for(int i=0; i<n; i++)
        scanf("%d", &arr[i]);
    long long value = 0;
    
    for(int i=0; i<n-1; i++) {
        differ[i] = abs(arr[i] - arr[i+1]);
        // printf("before differ = %d\n", differ[i]);
    }
    qsort(differ, n-1, sizeof(int), compare);

    for(int i=0; i<n-k; i++) {
        // printf("differ = %d\n", differ[i]);
        value += differ[i];
    }
    printf("%lld", value);
}