#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int n, m;
char word[100001][11];
int cnt;

// int compare(const void* a, const void* b) {
//     char tmp1 = 
// }

int main() {
    scanf("%d %d", &n,&m);
    for(int i=0; i<n; i++) {
        char* buffer;
        scanf("%s", buffer);
        int len = strlen(buffer);

        if(len >= m) {
            strcpy(word[cnt++], buffer);
        }
    }

    for(int i=0; i<cnt; i++)
        printf("\n%s\n", word[i]);
}