#include <stdio.h>

using namespace std;

int n,k; // 길이, 내구도 0인 칸 k개
int A[202]; // 내구도
int visit[202]; // 상자 있는지
int up, down, step, zero;

int main() {
    scanf("%d %d", &n,&k);
    up = 1;
    down = n;

    for(int i=1; i<=n*2; i++) {
        scanf("%d", &A[i]);
    }

    while(zero < k) {
        int idx = down;
        step++;
        up--;
        down--;
        if(up < 1) up = 2*n;
        if(down < 1) down = 2*n;
        
        if(zero>1) {
            if(visit[up] == 0 && A[up] >= 1) {
                visit[up] = 1;
                A[up+1]--;
                if(A[up+1] == 0) zero++;
            }
            // visit[down] = 0;
        }
        if(A[up] > 0) {
            A[up]--;
            if(A[up] == 0) {
                zero++;
            }
            visit[up] = 1;
        }
    }

    printf("%d", step);
}