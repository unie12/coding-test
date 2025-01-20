#include <stdio.h>
#include <iostream>
#include <deque>

using namespace std;

int n,k,m;

int main() {
    scanf("%d %d %d", &n, &k, &m);

    deque<int> dq;
    for(int i=1; i<=n; i++)
        dq.push_back(i);

    int count = 0;
    bool dir = true;

    while(!dq.empty()) {
        if(dir) {
            for (int i=0; i<k-1; i++) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
            printf("%d\n", dq.front());
            dq.pop_front();
        }
        else {
            for (int i=0; i<k-1; i++) {
                dq.push_front(dq.back());
                dq.pop_back();
            }
            printf("%d\n", dq.back());
            dq.pop_back();
        }

        count++;
        if(count == m) {
            dir = !dir;
            count = 0;
        }
    }

}