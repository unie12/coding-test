#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <vector>
using namespace std;

int n, m;
unordered_map<string, int> v;

bool comp(pair<string, int> &a, pair<string, int> &b) {
    if(a.second == b.second) {
        if( a.first.length() == b.first.length())
            return a.first < b.first;
        return a.first.length() > b.first.length();
    }
    return a.second > b.second;
}

int main(void) {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);


    cin >> n >> m;
    for(int i=0; i<n; i++) {
        string str;
        cin >> str;
        if( str.length() >= m)
            v[str]++;
    }

    vector<pair<string, int>> vec(v.begin(), v.end());
    sort(vec.begin(), vec.end(), comp);

    for(auto p : vec)
        cout << p.first << "\n";
}