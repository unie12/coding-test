#include <stdio.h>
#include <iostream>
#include <vector>
#include <utility>

using namespace std;

int r, c, n;
char board[201][201];

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void print() {
    for(int i=0; i<r; i++) {
        for(int j=0; j<c; j++){
            printf("%c", board[i][j]);
        } 
        printf("\n");
    }
}

int main() {
    scanf("%d %d %d", &r, &c, &n);
    getchar();
    for(int i=0; i<r; i++) {
        for(int j=0; j<c; j++) {
            scanf("%c", &board[i][j]);
        }
        getchar();
    }

    // 1초 그냥 출력, 2초(짝수초) 모두 채워서, 3초 -> 2초 때 있었던 폭탄 폭발
    // 5초(n%4 = 1) 3초에 채워진 폭탄 폭발
    if(n % 2 == 0) {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j] != 'O')
                    board[i][j] = 'O';
            }
        }
    }
    else if(n == 1) {
    }
    else if(n % 4== 3){
        vector<pair<int, int>> visit;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j] == '.')
                    board[i][j] = 'O';
                else {
                    board[i][j] = '.';
                    visit.push_back(make_pair(i,j));
                }
            }
        }
        for(int i=0; i<visit.size(); i++) {
            int curx = visit[i].first;
            int cury = visit[i].second;
            for(int j=0; j<4; j++) {
                int nx = curx + dx[j];
                int ny = cury + dy[j];

                if(nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] == 'O')
                    board[nx][ny] = '.';
            }
        }
    }
    else if(n % 4 == 1) {
        vector<pair<int, int>> visit;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j] == 'O')
                    visit.push_back(make_pair(i,j));
            }
        }
        while(!visit.empty()) {
            int curx = visit.back().first;
            int cury = visit.back().second;
            visit.pop_back();

            for(int j=0; j<4; j++) {
                int nx = curx + dx[j];
                int ny = cury + dy[j];

                if(nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] == '.')
                    board[nx][ny] = 'O';
            }
        }
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j] == '.')
                    visit.push_back(make_pair(i,j));
            }
        }
        while(!visit.empty()) {
            int curx = visit.back().first;
            int cury = visit.back().second;
            visit.pop_back();

            for(int i=0; i<4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c)
                    board[nx][ny] = '.';
            }
        }
    }

    print();

    return 0;
}