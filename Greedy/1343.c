#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char board[51];
char print[204];
int length, cnt;

int main() {
    scanf("%s", board);

    int len = strlen(board);
    // printf("len : %d\n", len);

    for(int i=0; i<len; i++) {
        if(board[i] == 'X'){
            cnt++;
            if(cnt%4 == 0){
                for(int j=0; j<4; j++)
                    print[length++] = 'A';
                cnt = 0;
            }
            else if(cnt%2 == 0){
                for(int j=0; j<2; j++)
                    print[length++] = 'B';
                cnt = 0;
            }

        }
        else if(board[i] == '.'){
            if(cnt == 0){
                print[length++] = '.';
                continue;
            }
            if(!(cnt%4 ==0 || cnt%2 ==0)){
                printf("-1");
                return 0;
            }

        }
    }
    if(cnt !=0){
        printf("-1");
        return 0;
    }
    // printf("%s\n", print);

    int blen = 0;
    for(int i=0; i<length; i++) {
        if(print[i] == 'B' && blen < 4)
            blen++;
        else if(print[i] == '.'){
            blen = 0;
            continue;

        }
        if(blen == 4){

        for(int j=i-3; j<=i; j++){
                print[j] = 'A';
            }
            blen = 0;
        }

    }
    printf("%s", print);
}