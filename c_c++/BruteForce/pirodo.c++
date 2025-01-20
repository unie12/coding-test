#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int answer = 0;
int visit[8];

void func(int cycle, int k, vector<vector<int>> vt) {
    if(cycle > answer) answer = cycle;

    for(int i=0; i<vt.size(); i++) {
        if(!visit[i] && vt[i][0] <= k) {
            visit[i] = 1;
            func(cycle+1, k-vt[i][1], vt);
            visit[i] = 0;
        }
    }
}   

int solution(int k, vector<vector<int>> dungeons) {
    func(0, k, dungeons);
    return answer;
}

int main() {
    vector<vector<int>> v;
    v.push_back({80, 20});
    v.push_back({50, 40});
    v.push_back({30, 10});
    
    int answer = solution(80, v);
    printf("answer:%d\n", answer);
}