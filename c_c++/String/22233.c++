#include <iostream> 
#include <algorithm>
#include <string>
#include <unordered_set>
using namespace std;

int n, m;
string keyword, note, token;
unordered_set<string> set;

int main() {
    cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

    cin >> n >> m;
    for(int i=0; i<n; i++) {
        cin >> keyword;
        set.insert(keyword);
    }

    for(int i=0; i<m; i++) {
        cin >> note;
        int pos = 0;
        
        while(true) {
            int count = note.find(",", pos);
            
            if(count != -1) {
                token = note.substr(pos, count - pos);
                if(set.find(token) != set.end()) {
                    set.erase(token);
                }
                pos = count + 1;
            }
            else {
                token = note.substr(pos);
                if(set.find(token) != set.end()) {
                    set.erase(token);
                }
                break;
            }
        }
        cout << set.size() << "\n";

    }
}