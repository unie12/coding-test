#include <stdio.h>
#include <string.h>

char arr[3001];

int main() {
    scanf("%s", &arr);

    int len = strlen(arr);
    int value = 0;
    for(int i=0; i<len; i++) {
        if(arr[i] == 'M') {
            value++;
        }
        else if(arr[i] == 'K') {
            printf("5");
            for(int i=0; i<value; i++)
                printf("0");
            value = 0;
        }
    }
    for(int i=0; i<value; i++)
        printf("1");
    printf("\n");

    value = 1;
    for(int i=0; i<len; i++) {
        if(arr[i] == 'M') {
            printf("%d", value);
            value = 0;
        }
        else if(arr[i] == 'K') {
            printf("5");
            value = 1;
        }
    }
}