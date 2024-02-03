#include <stdio.h>
#include <iostream>
#include <queue>

using namespace std;
int n, people;
int maesu, dasom;
priority_queue<int> q;

int main() {
    scanf("%d", &n);
    scanf("%d", &dasom);
    for(int i=1; i<n; i++) {
        scanf("%d", &people);
        q.push(people);
    }

    while (q.size() && q.top() >= dasom)
    {
        int cnt = q.top();
        q.pop();
        dasom++; maesu++;
        cnt--;
        q.push(cnt);
    }
    printf("%d", maesu);
    
}