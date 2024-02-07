#include <stdio.h>
#include <iostream>
#include <string>

using namespace std;

int k;
char sign[21];
int visit[10];
string maxVal, minVal;

int check(int i, int j, char k) {
    if(k == '<') return i < j;
    if(k == '>') return i > j;
    return 1;
}

void solve(int cnt, string s) {
    // cout << "solve : " << s <<  "\n";
    if(cnt == k + 1) {
        if(!maxVal.size()) {
            maxVal = s;
        }
        else {
            minVal = s;
        }
        return;
    }

    for(int i=0; i<10; i++) {
        if(visit[i] == 1) continue;
        if(cnt == 0 || check(s[cnt - 1], i+'0', sign[cnt - 1])) {
            visit[i] = 1;
            solve(cnt+1, s+to_string(i));
            visit[i] = 0;
        }
    }
}

int main() {
    scanf("%d", &k);
    for(int i=0; i<k; i++) {
        cin >> sign[i];
    }

    solve(0, "");

    cout << minVal << "\n";
    cout << maxVal << "\n";

}

