#include <stdio.h>
#include <stdlib.h>

int n;
int s[21][21];
int visit[410];
int answer = 987654321;

void func(int N, int index) {
    if(N == n/2) {
        int start =0, link =0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(visit[i] == 1 && visit[j] == 1) start += s[i][j];
                if(visit[i] == 0 && visit[j] == 0) link += s[i][j];
            }
        }

        int tmp = abs(start-link);
        if(tmp < answer) answer = tmp;

        return;
    }
    
    for(int i=index; i<n; i++) {
        visit[i] = 1;
        func(N+1, i+1);
        visit[i] = 0;
    }

}

int main() {
    scanf("%d", &n);

    for(int i=1; i<= n; i++) {
        for(int j=1; j<=n; j++) {
            scanf("%d", &s[i][j]);
        }
    }

    func(0, 1);

    printf("%d", answer);
}