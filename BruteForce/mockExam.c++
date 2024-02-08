#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int result[3] = {0, };
    int one[5] = {1, 2, 3, 4, 5};
    int two[8] = {2, 1, 2, 3, 2, 4, 2, 5};
    int three[10] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    int idx1 = 0, idx2 = 0, idx3 = 0;

    for(int i=1; i<=answers.size(); i++) {
        if(answers[i-1] == one[idx1]) result[0]++;
        idx1 = (idx1 + 1) % 5;

        if(two[idx2] == answers[i-1]) result[1]++;
        idx2 = (idx2+1) % 8;

        if(three[idx3] == answers[i-1]) result[2]++;
        idx3 = (idx3+1) % 10;
    }
    int maxVal = -1;
    for(int i=0; i<3; i++) {
        if(result[i] > maxVal) {
            maxVal = result[i];
            answer.clear();
            answer.push_back(i+1);
        }
        else if(result[i] == maxVal) {
            answer.push_back(i+1);
        }
    }
    return answer;
}

// #include <string>
// #include <vector>
// #include <algorithm>

// using namespace std;

// vector<int> one = {1,2,3,4,5};
// vector<int> two = {2,1,2,3,2,4,2,5};
// vector<int> thr = {3,3,1,1,2,2,4,4,5,5};

// vector<int> solution(vector<int> answers) {
//     vector<int> answer;
//     vector<int> they(3);
//     for(int i=0; i<answers.size(); i++) {
//         if(answers[i] == one[i%one.size()]) they[0]++;
//         if(answers[i] == two[i%two.size()]) they[1]++;
//         if(answers[i] == thr[i%thr.size()]) they[2]++;
//     }
//     int they_max = *max_element(they.begin(),they.end());
//     for(int i = 0; i< 3; i++) {
//         if(they[i] == they_max) answer.push_back(i+1);
//     }
//     return answer;
// }