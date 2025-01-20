#include <stdio.h>

using namespace std;

int n;

int paper[101][101];

int main() {
    scanf("%d", &n);
    
    for(int i=0; i<n; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        for(int x=a; x<a+10; x++)
            for(int y=b; y<b+10; y++)
                paper[x][y] = 1;
    }
    
    int sum  = 0;

    for(int i=0; i<100; i++)
        for(int j=0; j<100; j++)
            if(paper[i][j] == 1)
                sum++;
    printf("%d", sum);
}