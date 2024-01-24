#include <stdio.h>
#include <iostream>

using namespace std;
    
string king, stone;
int board[51][51];
int n;
int drow[8] = {0, 0, -1, 1, 1, 1, -1, -1};
int dcol[8] = {1, -1, 0, 0, 1, -1, 1, -1};
int rowIndex, colIndex;

int main() {
    cin >> king >> stone >> n;
    int sRow = stone[1] - '0';
    int sCol = stone[0] - '@';
    int kRow = king[1] - '0';
    int kCol = king[0] - '@';
    
    board[kRow][kCol] = 1;
    board[sRow][sCol] = 1;
    // printf("init %d %d  %d %d\n", kRow, kCol, sRow, sCol);

    for(int i=0; i<n; i++) {
        string move;
        int indx;
        cin >> move;

        if(move == "R") {
            indx = 0;
        }
        else if(move == "L") {
            indx = 1;
        }
        else if (move == "B")
        {
            indx = 2;
        }
        else if (move == "T")
        {
            indx = 3;
        }
        else if (move == "RT")
        {
            indx = 4;
        }
        else if(move == "LT") {
            indx = 5;
        }
        else if(move == "RB") {
            indx = 6;
        }
        else if(move == "LB") {
            indx = 7;
        }

        int nRow = kRow + drow[indx];
        int nCol = kCol + dcol[indx];
        if(nRow >8 || nCol > 8 || nRow < 1 || nCol < 1)
            continue;

        // 돌이랑 같은 곳
        if(board[nRow][nCol] == 1) {
            int snRow = sRow + drow[indx];
            int snCol = sCol + dcol[indx];

            if(snRow > 8 || snCol > 8 || snRow < 1 || snCol < 1)
                continue;
            else {
                sRow = snRow;
                sCol = snCol;
                board[sRow][sCol] = 1;
            }
        }
        board[kRow][kCol] = 0;
        kRow = nRow;
        kCol = nCol;
    }
    // for(int i=1; i<=8; i++) {
    //     for(int j=1; j<=8; j++) {
    //         printf("%d ",board[i][j]);
    //     }
    //     printf("\n");
    // }
    printf("%c%d\n", kCol + '@', kRow);
    printf("%c%d\n", sCol + '@', sRow);
}