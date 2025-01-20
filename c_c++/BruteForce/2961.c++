#include <stdio.h>
#include <math.h>
#include <vector>
#include <algorithm>

using namespace std;

int n, differ = 987654321, cnt;
int s, b;
// 신맛 = 사용한 재료의 신맛의 곱 = sour곱
// 쓴맛 = 사용한 재료의 쓴맛의 합 = bitter합

int main() {
    scanf("%d", &n);

    vector<pair<int, int>> v;
    for(int i=0; i<n; i++) {
        scanf("%d %d", &s, &b);
        v.push_back({s,b});
    } 

    for(int i=1; i<(1<<n); i++) {
        int a=1, b=0;
        for(int x=0; x<n; x++) {
            // i = 재료 선택 어떤거 했는지
            // 1<<x 몇 번째 재료 선택했는지 확인
            if(i & (1<<x)) {
                a *= v[x].first;
                b += v[x].second;
            }

        }
        differ = min(differ, abs(a-b));
        // printf("differ: %d\n", differ);
    }
    printf("%d", differ);
}