#include <stdio.h>
#include <iostream>
#include <stack>
#include <utility>

using namespace std;

int N, sum;
int tim = 1;

int main() {
    stack<pair<int, int>> stk;

    scanf("%d", &N);

    for(int i=0; i<N; i++) {
        int valid, A, T;
        scanf("%d", &valid);
        
        if(valid) {
            scanf("%d %d", &A, &T);
            stk.push({A, T});
            stk.top().second--;
            if(stk.top().second <= 0) {
                sum += stk.top().first;
                stk.pop();
            }
        }
        else {
            if(!(stk.empty())) {
                stk.top().second--;
                if(stk.top().second <= 0) {
                    sum += stk.top().first;
                    stk.pop();
                }
            }
        }
        // printf("%d\n", stk.top().second);
    }
    printf("%d", sum);
}