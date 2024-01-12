#include <stdio.h>
#include <stdlib.h>
#define max(a,b) (((a) > (b)) ? (a) : (b))
#define min(a,b) (((a) < (b)) ? (a) : (b))

int n;
int red, blue;
int answer;
char str[500001];

int main() {
    scanf("%d", &n);
    getchar();

    for(int i=0; i<n; i++) {
        scanf("%c", &str[i]);
        if(str[i] == 'R')
            red++;
        if(str[i] == 'B')
            blue++;
    }

    if(red ==0 || blue == 0) {
        printf("0");
        return 0;
    }

    answer = min(red, blue);
    int conti=0;

    for(int i=0; i<n; i++) {
        if(str[i] != str[0]) break;
        conti++;
    }
    if(str[0] == 'R')
        answer = min(red - conti, answer); 
    else
        answer = min(blue - conti, answer);


    conti = 0;
    for(int i=n-1; i>=0; i--) {
        if(str[i] != str[n-1]) break;
        conti++;
    }
    if(str[n-1] == 'R')
        answer = min(red - conti, answer); 
    else
        answer = min(blue - conti, answer);

    printf("%d", answer);
}
