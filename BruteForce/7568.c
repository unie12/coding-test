#include <stdio.h>

int n;
int x[51], y[51], r[51];

int main() {
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
        scanf("%d %d", &x[i], &y[i]);

    for (int i = 0; i < n; i++)
    {
        int height = x[i];
        int weight = y[i];
        for(int j=0; j<n; j++) {
            if(i == j)
                continue;
            if(height < x[j] && weight < y[j])
                r[i]++;
        }
    }
    for(int i=0; i<n; i++)
        printf("%d ", r[i]+1);

}