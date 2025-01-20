#include <stdio.h>

int n;
char arr[500001];
int rNum, bNum;
int min = 1;
int flag;

int main(){
    scanf("%d", &n);
    getchar();
    for(int i=0; i<n; i++){
        scanf("%c", &arr[i]);
    }

    for(int i=0; i<n; i++){
        if(arr[i] != arr[i+1] && arr[i] == 'R')
            rNum++;
        else if(arr[i] != arr[i+1] && arr[i] == 'B')
            bNum++;
    }
    if(rNum >= bNum)
        min = bNum +1;
    else
        min = rNum + 1;
    printf("%d", min);
    return 0;
}
