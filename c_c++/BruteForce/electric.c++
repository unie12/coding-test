#include <string>
#include <vector>
#include <math.h>
#include <iostream>

using namespace std;

vector<int> v[200];

int bfs(int togo, int now, int count) {
    for(int i=0; i<v[now].size(); i++) {
        if(v[now][i] != togo) {
            count = bfs(now, v[now][i], count+1);
        }
    }
    return count;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 987654321;
    // 양방향 연결
    for(auto w : wires) {
        v[w[0]].push_back(w[1]);
        v[w[1]].push_back(w[0]);
    }

    // for(int i=1; i<=n; i++) {
    //     cout << "Node " << i << ": ";
    //     for(int j=0; j<v[i].size(); j++) {
    //         cout << v[i][j] << " ";
    //     }
    // cout << endl;
    // }

    for(auto w : wires) {
        int sum = bfs(w[0], w[1], 1);
        int comp = n - (2*sum);
        answer = min(answer, abs(comp));
    }
    return answer;
}

int main() {
    vector<vector<int>> tmp;
    tmp.push_back({1,3});
    tmp.push_back({2,3});
    tmp.push_back({3,4});
    tmp.push_back({4,5});
    tmp.push_back({4,6});
    tmp.push_back({4,7});
    tmp.push_back({7,8});
    tmp.push_back({7,9});
    int answer = solution(9, tmp);

    printf("%d", answer);
}