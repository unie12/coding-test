#include <stdio.h>
#include <string>
#include <iostream>
#include <algorithm>

using namespace std;

int a, direction; // 0 남쪽, 1 서쪽, 2 북쪽, 3 동쪽
int map[101][101];
int R = 50, C = 50;
int R_min, R_max, C_min, C_max;
string s;

int main() {
    scanf("%d", &a);
    cin >> s;

    map[R][C] = 1;
    R_min = R_max = C_max = C_min = 50;

    for(int i=0; i<a; i++) {
        if (s[i] == 'L') direction--;
        else if(s[i] == 'R') direction++;
        else if(s[i] == 'F') {
            if(direction == 0) R++;
            else if(direction == 1) C--;
            else if(direction == 2) R--;
            else if(direction == 3) C++;
            map[R][C] = 1;
        }

        if(direction < 0) direction = 3;
        else if(direction >3) direction = 0;

        R_min = min(R_min, R);
        R_max = max(R_max, R);
        C_min = min(C_min, C);
        C_max = max(C_max, C);
    }

    for(int i=R_min; i<=R_max; i++) {
        for(int j=C_min; j<=C_max; j++) {
            cout << (map[i][j] ? '.' : '#');
        }
        cout << '\n';
    }

}