#include <iostream>
#include <algorithm>
using namespace std;

int n, k;
int str2[26];

int main() {
    cin >> n;
    for(int i=0; i<n; i++) {
        string str;
        cin >> str;
        str2[str[0] - 'a']++;
    }
    for(int i=0; i<26; i++ ) {
        if(str2[i] >= 5) {
            cout << (char)('a' +i);
            k=1;
        }
    }
    if(k==0) cout << "PREDAJA";
}