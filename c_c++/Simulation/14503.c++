#include <stdio.h>
#include <iostream>

using namespace std;

int n,m,d, row, col;
int place[51][51];
int visit[51][51];
int clean, state;

int dRow[4] = {0, 0, -1, 1};
int dCol[4] = {-1, 1, 0, 0};

void one() {
    if(place[row][col] == 0 && visit[row][col] == 0) {
        clean++;
        visit[row][col] = 1;
    }
}

int check() {
    for(int i=0; i<4; i++) {
        int nRow = row + dRow[i];
        int nCol = col + dCol[i];

        if(nRow > n || nCol > m || nRow < 0 || nCol < 0) {
            continue;
        }
        if(place[nRow][nCol] == 1 || visit[nRow][nCol] != 0) {
            continue;
        }
        return 3;
    }
    return 2;
}

int two() {
    int nRow = row, nCol = col;
    // 북쪽 바라보는 중
    if(d == 0) {
        nRow = row + 1;
    }
    // 동쪽 바라보는 중
    else if(d == 1) {
        nCol = col - 1;
    }
    // 남쪽
    else if(d == 2) {
        nRow = row - 1;
    }
    else if(d ==  3) {
        nCol = col + 1;
    }

    if(nRow > n || nCol > m || nRow < 0 || nCol < 0)
        return 0;
    if(place[nRow][nCol] == 1)
        return 0;
    row = nRow;
    col = nCol;
    return 1;
}

int three() {
    int nRow = row, nCol = col;
    // 북쪽 -> 서쪽
    if(d == 0) {
        d = 3;
        nCol = col - 1;
    }
    // 동쪽 -> 북쪽
    else if(d == 1) {
        d = 0;
        nRow = row - 1;
    }
    // 남쪽 -> 동쪽
    else if(d == 2) {
        d = 1;
        nCol = col + 1;
    }
    // 서쪽 -> 남쪽
    else if(d ==  3) {
        d = 2;
        nRow = row + 1;
    }

    if(nRow > n || nCol > m || nRow < 0 || nCol < 0)
        return 0;
    if(place[nRow][nCol] == 1 || visit[nRow][nCol] != 0)
        return 0;

    row = nRow;
    col = nCol;
    return 1;
}  

int main() {
    scanf("%d %d", &n, &m);
    scanf("%d %d %d", &row, &col, &d);

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            scanf("%d" ,&place[i][j]);
        }
    }


    while(true) {
        one();
        if(check() == 2) {
            // printf("row: %d col: %d check: %d\n", row, col, check());
            if(two() == 0)
                break;
        }
        else if(check() == 3) {
            // printf("row: %d col: %d check: %d dval: %d\n", row, col, check(), d);
            for(int i=0; i<4; i++) {
                if(three() == 1)
                    break;
            }
        }
    }
    printf("%d", clean);
    return 0;
}