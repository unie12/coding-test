#include<iostream>
#include<string>
#include<algorithm>
#include<vector>
using namespace std;
string str;
int str2[26];

int main() {
    cin >> str;

    int len = str.length();
    for(int i=0; i<len; i++) {
        str2[str[i] - 'A']++;
    }

    int odd = 0;
    int oddIndex = 0;
    for(int i=0; i<26; i++) {
        if(str2[i] %2 == 1) {
            odd++;
            oddIndex = i;
        }
        if(odd >=2) {
            cout << "I'm Sorry Hansoo";
            return 0;
        }
    }

    string result = "";
    for(int i=0; i<26; i++) {
        if(str2[i] == 0) continue;

        for(int j=0; j<str2[i]/2; j++) {
            result = result + char(i + 'A');
        }
    }
    string resverseResult = result;
    reverse(resverseResult.begin(), resverseResult.end());

    if(odd == 1) {
        result = result + char(oddIndex + 'A') + resverseResult;
    }
    else {
        result = result + resverseResult;
    }

    cout << result;
}