#include <stdio.h>

int n, k;
char arr[20001];
int people;

int main() {
    scanf("%d %d", &n, &k);
    getchar();

    for(int i=1; i<=n; i++) {
        scanf("%c", &arr[i]);
    }

    for(int i=1; i<=n; i++) {
        if(arr[i] != 'P')
            continue;
        for(int j=i-k; j<=i+k; j++) {
            if(arr[j] == 'H') {
                people++;
                arr[j] = '0';
                arr[i] = '0';
                break;
            }
        }
    }
    printf("%d", people);
}