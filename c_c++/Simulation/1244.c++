#include <stdio.h>

int s, student, sex, number;
int state[105];

int main() {
    scanf("%d", &s);
    for(int i=1; i<=s; i++) {
        scanf("%d", &state[i]);
    }
    
    scanf("%d", &student);
    for(int i=0; i<student; i++) {
        scanf("%d %d", &sex, &number);
        // 남자
        if(sex == 1) {
            for(int j=number; j<=s; j += number) {
                state[j] = !state[j];
            }
        }
        else {
            int left, right;
            left = number - 1;
            right = number + 1;
            while(left>0 && right<=s) {
                if(state[left] == state[right]) {
                    state[left] = !state[left];
                    state[right] = !state[right];
                    left--;
                    right++;
                }
                else
                    break;
            }
            state[number] = !state[number];
        }
    }
    for(int i=1; i<=s; i++) {
        if(i %20 == 0 || i == s) {
            printf("%d", state[i]);
            printf("\n");
            continue;
        }
        printf("%d ", state[i]);
    }
}