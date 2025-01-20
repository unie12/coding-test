#include <stdio.h>
#include <iostream>

using namespace std;
int h,w;
char city[101][101];
int visit[101][101];

int main() {
    scanf("%d %d", &h,&w);

    for(int i=0; i<h; i++) {
        for(int j=0; j<w; j++) {
            cin >> city[i][j];
        }
    }
    
    for(int i=0; i<h; i++) {
        for(int j=0; j<w; j++) {
            if(city[i][j] == 'c') {
                visit[i][j] = 1;
                // printf("ival: %d jval: %d\n", i,j);
                for(int k=j+1; k<w; k++) {
                    visit[i][k] = visit[i][k-1] + 1;
                }
            }

        }
    }


    for(int i=0; i<h; i++) {
        for(int j=0; j<w; j++) {
            printf("%d ", visit[i][j] - 1);
        }
        printf("\n");
    }
}