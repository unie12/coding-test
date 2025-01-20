#include <stdio.h>
#include <string>
#include <iostream>
#include <algorithm>

using namespace std;

int T;
string str;

int dir, r, c;
int max_x, max_y, min_x, min_y;

int main() {    
    scanf("%d", &T);


    for(int i=0; i<T; i++) {
        int plane[501][501];
        cin >> str;
        dir=0;
        r = c = 250;
        max_x = max_y = min_x = min_y = 250;
        plane[r][c] = 1;
        for(int j=0; j<str.length(); j++) {
            if(str[j] == 'F') { // 0: 북, 1: 동, 2: 남, 3: 서
                if(dir == 0) plane[--r][c] = 1;
                else if(dir == 1) plane[r][++c] = 1;
                else if(dir == 2) plane[++r][c] = 1;
                else if(dir == 3) plane[r][--c] = 1;
            }
            else if(str[j] == 'B') {
                if(dir == 0) plane[++r][c] = 1;
                else if(dir == 1) plane[r][--c] = 1;
                else if(dir == 2) plane[--r][c] = 1;
                else if(dir == 3) plane[r][++c] = 1;
            }
            else if(str[j] == 'L') dir--;
            else if(str[j] == 'R') dir++;

            if (dir < 0) dir = 3;
            else if(dir > 3) dir = 0;

            max_x = max(max_x, r);
            max_y = max(max_y, c);
            min_x = min(min_x, r);
            min_y = min(min_y, c);
        }

        printf("%d\n", (max_x - min_x) * (max_y - min_y));
    }
}