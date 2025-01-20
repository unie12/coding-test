#include <stdio.h>
#include <stdlib.h>

int n, m;
int limit[51], box[10001];

int compare(const void* a, const void* b) {
    if(*(int*)a > *(int*)b)
        return -1;
    else if(*(int*)a < *(int*)b)
        return 1;
    else
        return 0;
}

int main() {
    scanf("%d", &n);
    for(int i=0; i<n; i++)
        scanf("%d", &limit[i]);

    scanf("%d", &m);
    for(int i=0; i<m; i++)
        scanf("%d", &box[i]);

    qsort(limit, n, sizeof(int), compare);
    qsort(box, m, sizeof(int), compare);

    if(box[0] > limit[0]) {
        printf("-1");
        return 0;
    }  

    int step = 0;
    int zero = 0;
/***
 * two pointer 이용
*/
    int i = 0, j = 0;
    while(zero !=m) {
        if(limit[i] >= box[j] && box[j] != 0) {
            // printf("ival: %d box[%d] = %d\n", i,j, box[j]);
            zero++;
            i++;
            box[j] = 0;
        }
        j++;
        if(i==n || j == m || zero == m) {
            i = 0;
            j = 0;
            step++;
            // printf("%d\n", step);
        }
    }
    printf("%d", step);
    
    // while(1) {
    //     for(int i=0;i<n; i++) {
    //         for(int j=0; j<m; j++) {
    //             if(limit[i] >= box[j] && box[j] != 0) {
    //                 box[j] = 0;
    //                 zero++;
    //                 break;
    //             }
    //         }
    //     }
    //     // printf("%d\n", zero);
    //     step++;
    //     if(zero == m) {
    //         printf("%d", step);
    //         return 0;
    //     }
    // }
}