#include <stdio.h>

using namespace std;
int n, m;
int result, min_result = 987654321;
char board[51][51];

void check(int row, int col) {
    result = 0;
    for(int i = row; i < row + 8; i++) {
        for(int j = col; j < col + 8; j++) {
            if((i + j) % 2 == 0) {
                if(board[i][j] != 'W') result++;
            }
            else {
                if(board[i][j] == 'W') result++;
            }
        }
    }
    if(result < min_result) min_result = result;

    result = 0;
    for(int i = row; i < row + 8; i++) {
        for(int j = col; j < col + 8; j++) {
            if((i + j) % 2 == 0) {
                if(board[i][j] != 'B') result++;
            }
            else {
                if(board[i][j] == 'B') result++;
            }
        }
    }
    if(result < min_result) min_result = result;

}

int main() {
    scanf("%d %d", &n, &m);
    getchar();

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            scanf("%c", &board[i][j]);
        }
        getchar();
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(n-i-8 >= 0 && m-j-8 >= 0) {
                check(i, j);
            }
        }
    }
    printf("%d", min_result);
}