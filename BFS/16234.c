#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int x;
    int y;
} location;

typedef struct {
    int sum;
    int num;
} unionInfo;

int N, L, R;
int map[50][50];
int visit[50][50];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

location queue[2500];
unionInfo unions[2500];

void bfs(int x, int y, int index) {
    int front = 0, rear = 0;
    int unionSum = map[x][y], unionNum = 1;
    queue[rear].x = x;
    queue[rear].y = y;
    rear++;
    visit[x][y] = index;

    while (front < rear) {
        location cur = queue[front++];
        for (int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visit[nx][ny] > 0) continue;
            int diff = abs(map[cur.x][cur.y] - map[nx][ny]);
            if (diff >= L && diff <= R) {
                queue[rear].x = nx;
                queue[rear].y = ny;
                rear++;
                visit[nx][ny] = index;
                unionSum += map[nx][ny];
                unionNum++;
            }
        }
    }

    unions[index].sum = unionSum;
    unions[index].num = unionNum;
}

int main() {
    scanf("%d %d %d", &N, &L, &R);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            scanf("%d", &map[i][j]);
        }
    }

    int result = 0;
    while (1) {
        memset(visit, 0, sizeof(visit));
        int index = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == 0) {
                    bfs(i, j, ++index);
                }
            }
        }

        if (index == N * N) break;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = unions[visit[i][j]].sum / unions[visit[i][j]].num;
            }
        }

        result++;
    }

    printf("%d\n", result);

    return 0;
}



/*
#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int x;
    int y;
}Que;

typedef struct{
    int sum;
    int val;
}Infor;


int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

Infor infor[2509];
Que que[2509];
int flag;
int visit[51][51];
int blank[51][51];
int index[51][51];

int front, rear;
int N, L, R; // N*N matrix, L: 최소 인구수, R: 최대 인구수
int people;
int blankValue;
int inforIndex = 0;
int day;

void bfs(void){
    day++;
    while(front != rear){
        Que tmpQue = que[++front];
        // visit[tmpQue.x][tmpQue.y] = 1;

        for(int i=0; i<4; i++){
            int nx = tmpQue.x +  dx[i];
            int ny = tmpQue.y +  dy[i];

            if(nx < 0 || ny < 0 || nx>=N || ny>=N)
                continue;
            if(visit[nx][ny] != 0)
                continue;
            int differ = abs(blank[tmpQue.x][tmpQue.y] - blank[nx][ny]);
            if(L <= differ && differ <= R){
                // printf("BEFORE: blank: %d people: %d\n", blank[nx][ny], people);

                visit[nx][ny] = 1;
                que[++rear].x = nx;
                que[rear].y = ny;
                index[nx][ny] = inforIndex;

                flag++;
                people = people + blank[nx][ny];
                blankValue++;
                // printf("AFTER: blank: %d people: %d\n", blank[nx][ny], people);
            }
        }
    }
    // return flag;
}*/
/*
int main(){
    int num = 0;
    scanf("%d %d %d", &N, &L, &R);
    for(int i=0; i<N; i++){
        for(int j=0; j<N;j++){
            scanf("%d", &blank[i][j]);
        }
    }
    for(int k=0; k<2000; k++){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visit[i][j] == 0){
                    que[++rear].x = i;
                    que[rear].y = j;
                    visit[i][j] = 1;
                    index[i][j] = inforIndex;
                    blankValue = 1;
                    people = blank[i][j];
                    flag = 1;
                    printf("bfs start: blank[%d][%d]\n", i,j);
                    bfs();
                    /*if(num ==  1){
                        inforIndex++;
                        printf("blank[%d][%d] only one\n", i, j);
                    }
                    else{
                        infor[inforIndex].sum = people;
                        infor[inforIndex].val = blankValue;
                    }*/
                    
                    /*

                    infor[inforIndex].sum = people;
                    infor[inforIndex++].val = blankValue;
                }
            }
        }
        printf("blankVal: %d inforIndex: %d flag: %d day: %d rear: %d\n", blankValue, inforIndex, flag, day, rear);
        num++;

        if(flag == 1){
            // add code
            break;
        }
        for(int i=0; i<inforIndex; i++){
            for(int j=0; j<N;j++){
                for(int k=0; k<N; k++){
                    if(index[j][k] == i){
                        blank[j][k] = infor[i].sum/infor[i].val;
                    }
                }
            }
        }
        
        /*
        printf("****************\n");
        for(int i=0; i<N; i++){
            for(int j=0; j<N;j++){
                printf("%d ", blank[i][j]);
            }
            printf("\n");
        }
        printf("****************\n");
        */
/*        for(int i=0; i<N; i++){
            for(int j=0; j<N;j++){
                visit[i][j] = 0;
                index[i][j] = 0;
                rear=front=0;
                people = 0;
                inforIndex = 0;
            }
        }
    }
    
    // printf("%d\n", inforIndex);

    // for(int i=0; i<inforIndex; i++)
    //     printf("pepole: %d Index: %d\n", infor[i].sum, infor[i].val);
    /*if(inforIndex == N*N){
        printf("0");
        return 0;
    }*/

    // 이동 후 다시 이동해야 하는 경우
    
/*  printf("%d %d\n", day, num);
}*/




