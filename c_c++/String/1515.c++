#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

string str;

int main() {
    cin >> str;
    int cnt = 0;
    int len = str.length();
    int i = 0;

    // 최대 3000자리이지만, 모두 이어붙이지므로 26000까지 맞음
    while(cnt++ < 30001) {
        string tmpCnt = to_string(cnt);

        for(int j=0; j<tmpCnt.length(); j++) {
            if(str[i] == tmpCnt[j]) {
                i++;
            }
            if(len == i) {
                cout << cnt;
                return 0;
            }
        }
    }
}