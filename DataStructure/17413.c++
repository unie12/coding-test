#include <stdio.h>
#include <iostream>
#include <stack>
#include <string>

using namespace std;

void stackprint(stack<char> &stak) {
    while(!stak.empty()) {
        cout << stak.top();
        stak.pop();
    }
}

int main() {
    stack<char> stk;
    string s;
    getline(cin, s);
    int len = s.size();
    
    for(int i=0; i<len; i++) {
        if(s[i] == '<') {
            stackprint(stk);
            while(1) {
                cout << s[i];
                if(s[i] == '>')
                    break;
                i++;
            }
        }
        else if(s[i] == ' ') {
            stackprint(stk);
            cout << " ";
        }
        else {
            stk.push(s[i]);
        }
    }
    stackprint(stk);
}