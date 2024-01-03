#include <stdio.h>
#include <stdlib.h>

int n;
int tip[100001];

int compare(const void* a, const void* b) {
    if(*(int*)a < *(int*)b)
        return 1;
    else if(*(int*)a > *(int*)b)
        return -1;
    else
        return 0;
}

int main() {
    scanf("%d", &n);

    for(int i=0; i<n; i++)
        scanf("%d", &tip[i]);

    qsort(tip, n, sizeof(int), compare);

    long long increasePrice = 0;
    for(int i=0; i<n; i++){
        int tipPrice = tip[i] - i;
        if(tipPrice >= 0)
            increasePrice += tipPrice;
    }   

        printf("%lld", increasePrice);

}