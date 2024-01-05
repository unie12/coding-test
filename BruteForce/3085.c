#include <stdio.h>
#include <stdlib.h>
#define swap(a,b) {int tmp=a; a=b; b=tmp;}

int n;
int max;
char candy[51][51];

void check() {
    for(int i=0; i<n; i++) {
        char tmp = candy[i][0];
        int count = 1;
        for(int j=1; j<n; j++) {
            // printf("tmp: %c candy: %c\n",tmp, candy[i][j]);
            if(tmp == candy[i][j]){
                count++;
            }
            else
                count = 1;
            
            tmp = candy[i][j];
            if(count > max)
                max = count;
        }
    }   

    for(int j=0; j<n; j++) {
        char tmp = candy[0][j];
        int count = 1;
        for(int i=1; i<n; i++) {
            if(tmp == candy[i][j])
                count++;
            else
                count = 1;
            
            tmp = candy[i][j];
            if(count > max)
                max = count;
        }
    }
}

int main() {
    scanf("%d", &n);
    getchar();

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            scanf("%c", &candy[i][j]);
        }
        getchar();
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n-1; j++) {
            swap(candy[i][j], candy[i][j+1])
            check();
            swap(candy[i][j], candy[i][j+1])
        }
    }
    for(int j=0; j<n; j++){
        for(int i=0; i<n-1; i++) {
            swap(candy[i][j], candy[i+1][j])
            check();
            swap(candy[i][j], candy[i+1][j])
        }
    }

    printf("%d",max);
}