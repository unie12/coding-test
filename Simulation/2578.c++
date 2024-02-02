#include <stdio.h>
#include <iostream>
#include <queue>

using namespace std;

int board[6][6];
int answer;
int visit[6][6];
int result, bingo;
queue<int> q;

int main() {
    for(int i=0; i<5; i++)
        for(int j=0; j<5; j++)
            scanf("%d",&board[i][j]);

    for(int i=0; i<25; i++) {
        scanf("%d", &answer);
        q.push(answer);
    }

    while(true) {
        bingo = 0;
        // printf("\n");
        // for(int i=0; i<5; i++) {
        //     for(int j=0; j<5; j++) {
        //         printf("%d ", visit[i][j]);
        //     }
        //     printf("\n");
        // }

        int check =0;
        answer = q.front();
        q.pop();

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(board[i][j] == answer) {
                    visit[i][j] = 1;
                    check = 1;
                    break;
                }
            }
            if(check)
                break;
        }

        for(int i=0; i<5; i++) {
            int check2 = 0;
            for(int j=0; j<5; j++) {
                if(visit[i][j] == 0) {
                    check2 = 1;
                    break;
                }
            }
            if(check2 == 0)
                bingo++;
        }

        for(int i=0; i<5; i++) {
            int check3 = 0;
            for(int j=0; j<5; j++) {
                if(visit[j][i] == 0) {
                    check3 = 1;
                    break;
                }
            }
            if(check3 == 0)
                bingo++;
        }

        int check4 = 0;
        for(int i=0; i<5; i++) {
            if(visit[i][i] == 0) {
                check4 = 1;
                break;
            }
        }
        if(check4 == 0)
            bingo++;

        int check5 = 0;
        for(int i=4; i>=0; i--) {
            if(visit[i][4-i] == 0) {
                check5 = 1;
                break;
            } 
        }
        if(check5 == 0)
            bingo++;

        if(bingo >= 3)
            break;
    }


    printf("%d", 25 - q.size());
}