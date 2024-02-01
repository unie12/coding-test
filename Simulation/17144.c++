#include <stdio.h>
#include <iostream>

using namespace std;

int r,c,t;
int a[51][51];
int munge;
int cleaner, clean_up, clean_down;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void spread() {
    int add[51][51] = {0, };

    for(int i=1; i<=r; i++) {
        for(int j=1; j<=c; j++) {
            int cnt = 0;
            if(a[i][j] == -1 || a[i][j]<5)
                continue;
            for(int k=0; k<4; k++) {
                int nRow = dx[k] + i;
                int nCol = dy[k] + j;

                if(nRow < 1 || nCol < 1 || nRow > r || nCol > c)
                    continue;
                if(a[nRow][nCol] == -1)
                    continue;
                
                add[nRow][nCol] += a[i][j]/5;
                cnt++;
            }
            a[i][j] = a[i][j] - cnt*(a[i][j]/5);
        }
    }

    for(int i=1; i<=r; i++) {
        for(int j=1; j<=c; j++) {
            a[i][j] += add[i][j];
        }
    }
}

void airContion() {
    // for(int i=1; i<=r; i++) {
    //     for(int j=1; j<=c; j++) {
    //         printf("%d ", a[i][j]);
    //     }
    //     printf("\n");
    // }
    // printf("\n");

    clean_up = cleaner - 1;
    clean_down = cleaner;

    for (int i = clean_up; i > 0; i--) {
        a[i + 1][1] = a[i][1];
    }

    for (int i = clean_down; i <= r; i++) {
        a[i][1] = a[i + 1][1];
    }


    for (int i = 1; i <= c; i++) {
        a[1][i] = a[1][i + 1];
        a[r][i] = a[r][i + 1];
    }

    for (int i = 1; i <= clean_up ; i++) {
        a[i][c] = a[i + 1][c];
    }

    for (int i = r; i >= clean_down; i--) {
        a[i][c] = a[i - 1][c];
    }

    for (int i = c ; i >= 1; i--) {
        a[clean_up][i] = a[clean_up][i - 1];
        a[clean_down][i] = a[clean_down][i - 1];
    }
    a[clean_up][2] = 0;
    a[clean_down][2] = 0;


    a[clean_up][1] = -1;
    a[clean_down][1] = -1;   
}

void simulation() {
    spread();
    airContion();
}

int main() {
    scanf("%d %d %d", &r,&c,&t);
    for(int i=1; i<=r; i++) {
        for(int j=1; j<=c;j++) {
            scanf("%d", &a[i][j]);
            if(a[i][j] == -1)
                cleaner = i;
        }
    }

    // printf("\n");

    for(int i=0; i<t; i++)
        simulation();

    for(int i=1; i<=r; i++) {
        for(int j=1; j<=c; j++) {
            munge += a[i][j];
        }
    }
    printf("%d", munge+2);
}
