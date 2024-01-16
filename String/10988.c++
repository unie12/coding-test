#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    string str, tmp;
    cin >> str;
    // tmp = str;
    // reverse(tmp.begin(), tmp.end());
    // if(str == tmp)
    //     cout << 1;
    // else
    //     cout << 0;

    int len = str.length();
    for(int i=0; i<=len/2; i++) {
        if(str[i] == str[len-i-1])
            continue;
        else {
            cout << 0;
            return 0;
        }
    }
    cout << 1;

}