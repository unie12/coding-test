#include <stdio.h>
#include <stdlib.h>
#define max(a,b) (((a) > (b)) ? (a) : (b))

int n;
int val[21][101];

typedef struct{
    int hp;
    int pleasure;
}Infor;

Infor infor[21];

int main(){
    scanf("%d", &n);
    for(int i=1; i<=n; i++)
        scanf("%d", &infor[i].hp);
    for(int i=1; i<=n; i++)
        scanf("%d", &infor[i].pleasure);

    for(int i=1; i<=n; i++){
        for(int j=0; j<=100; j++){
            int tmpHp = infor[i].hp;
            int tmpPl = infor[i].pleasure;

            if(tmpHp >= j){
                val[i][j] = val[i-1][j];
            }
            else{
                val[i][j] = max(val[i-1][j], tmpPl+val[i-1][j-tmpHp]);
            }
            // printf("val[%d][%d] = %d\n", i, j, val[i][j]);
            // val[n][100] = max(val[n][100] , val[i][j]);
        }
    }

    printf("%d", val[n][100]);
}