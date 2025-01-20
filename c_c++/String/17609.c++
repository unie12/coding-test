#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int t, len;
string str;

bool is_pali() {
    int left = 0, right = len-1;
    while(left <= right) {
        if(str[left++] != str[right--]) return false;
    }
    return true;
}

bool can_pali(int left, int right, bool skip) {
    if(left > right) return true;
    if(str[left] == str[right]) return can_pali(left+1, right-1, skip);
    else if(skip) return max(can_pali(left+1, right, false), can_pali(left, right-1, false));
    else return false;
}

int getAnswer() {
    if(is_pali()) return 0;
    else if(can_pali(0, len-1, 1)) return 1;
    else return 2;
}

int main() {
    cin >> t;

    for(int i=0; i<t; i++) {
        cin >> str;
        len = str.size();
        cout << getAnswer() << "\n";
    }
}