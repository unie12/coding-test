#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int n, w, l;
int a[1001];
int time1;
queue<int> q;

int main() {
    scanf("%d %d %d", &n, &w, &l);
    for(int i=0; i<n; i++) {
        scanf("%d", &a[i]);
    }

    int weight = 0;
    for(int i=0; i<n; i++) {  
        while(true) {
            // queue<int> temp = q;
            // printf("%d√ : ", time1);
            // while(!temp.empty()) {
            //     printf("%d ", temp.front());
            //     temp.pop();
            // }
            // printf("\n");

            if(q.size() == w) {
                weight = weight - q.front();
                q.pop();
            }
            if(a[i] + weight <= l) {
                break;
            }
            q.push(0);
            time1++;
        }
        q.push(a[i]);
        weight += a[i];
        time1++;
    }
    printf("%d", time1 + w);   

}