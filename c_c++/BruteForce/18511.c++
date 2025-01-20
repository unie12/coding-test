#include <stdio.h>
#include <vector>
#include <string>
#include <iostream>

using namespace std;
int k;
string n, result;
int answer;

void solution(vector<int> vt) {
    if(result.length()>0 && stoi(n) >= stoi(result)) {
        answer = max(answer, stoi(result));
    }
    if(result.length() == n.length())
        return;

    for(int i=0; i<vt.size(); i++) {
        result = result + to_string(vt[i]);
        solution(vt);
        result.pop_back();   
    }
}

// stoi
int main() {
    cin >> n >> k;
    vector<int> v(k);

    for(int i=0; i<k; i++) {
        cin >> v[i];
    }

    solution(v);

    printf("%d", answer);
}