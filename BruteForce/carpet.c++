#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;

    int area = brown + yellow;

    for(int i=3; i<=area; ++i)
    {
        if(area%i == 0)
        {
            int width = area/i;

            if((i-2) * (width-2) == yellow)
            {
                answer.push_back(width);
                answer.push_back(i);
                break;
            }
        }
    }
    return answer;
}

// vector<int> solution(int brown, int yellow) {
//     vector<int> answer;

//     int i = 1;
//     int width = yellow/i, length = width*2 + 6;
//     // printf("first width: %d length: %d\n", width, length);

//     while(!(brown+yellow == (width+2) * (i+2))) {
//         i++;
//         width = yellow/i;
//         if(width == 0)
//             width = 1;
//         length = width*2 + (i+2)*2;
//         // printf("ival: %d width: %d length:%d\n", i, width, length);
//     }
//     answer.push_back(width+2);
//     answer.push_back(i+2);
//     return answer;
// }

int main() {
    vector<int> answer = solution(24, 24);
    cout << answer.front() << " " << answer.back();
}

