#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int t, n;
string number;
bool check;

int main() {
    scanf("%d", &t);

    for(int i=0; i<t; i++) {
        vector<string> set;
        check = true;
        scanf("%d" ,&n);
        for(int j=0; j<n; j++) {
            // scanf("%s", number);
            cin >> number;
            set.push_back(number);
        }

        sort(set.begin(), set.end());
        for(int j=0; j<n-1; j++) {
            // cout << set[j] << " + " << set[j+1] << "\n";
            if(set[j] == set[j+1].substr(0, set[j].length())) {
                printf("NO\n");
                check = false;
                break;
            }
        }
        if(check)
            printf("YES\n");
    }
}