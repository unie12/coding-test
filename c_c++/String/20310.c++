#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    string str;
    cin >> str;

    int len = str.length();
    int zero = 0;
    int one = 0;

    for(int i =0; i<len; i++) {
        if(str[i] == '0') 
            zero++;
        else
            one++;
    }

    
    zero /= 2;
    one /= 2;

    for(int i=0; i<len; i++) {
        if(str[len-1-i] == '0' && zero != 0) {
            str.erase(len-1-i, 1);
            zero--;
            i--;
        }
        if(str[i] == '1' && one != 0) {
            str.erase(i, 1);
            one--;
            i--;
        }
        // cout << str << "\n";
    }
    len = str.length();
    for(int i=0; i<len; i++)
        cout << str[i];
}