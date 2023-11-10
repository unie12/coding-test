#include <stdio.h>

/*typedef struct {
    int parent;
    int child;
}Que;*/

int map[101][101];
int que[101];
int visit[101];
int front, rear;
int n, m;
int num1, num2;

void bfs(void){
    visit[num1] = 1;
    que[++rear] = num1;
    while ((front != rear))
    {
        int tmp = que[++front];
        for(int i=1; i<=n; i++) {
            if(map[tmp][i] == 1 && visit[i] == 0) {
                que[++rear] = i;
                visit[i] = visit[tmp] + 1;
            }
        }
    }
    
}

int main(){
    scanf("%d", &n);
    scanf("%d %d", &num1, &num2);
    scanf("%d", &m);

    for(int i=0; i<m; i++){
        int tmp1, tmp2;
        ++rear;
        scanf("%d %d", &tmp1, &tmp2);
        map[tmp1][tmp2] = 1;
        map[tmp2][tmp1] = 1;
    }

    bfs();

    if(visit[num2] == 0){
        printf("-1");
        return 0;
    }
    printf("%d", visit[num2]-1);
    return 0;
}