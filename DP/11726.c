#include <stdio.h>

int n;
int method[1001];

int main(){
    method[1] = 1;
    method[2] = 2;

    scanf("%d", &n);
    if(n <=2){
        printf("%d", n);
        return 0;
    }

    for(int i = 3; i<= n; i++){
        method[i] = method[i-1] + method[i-2];
        method[i] %= 10007;
    }
    printf("%d", method[n]);
}