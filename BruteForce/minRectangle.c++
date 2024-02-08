#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int maxVal = -1, maxVal2 = -1;

    for(int i=0; i<sizes.size(); i++) {
        int tmpMax, tmpMax2;
        if(sizes[i][0] > sizes[i][1]) {
            tmpMax = sizes[i][0];
            tmpMax2 = sizes[i][1];
        }
        else {
            tmpMax = sizes[i][1];
            tmpMax2 = sizes[i][0];
            sizes[i][1] = sizes[i][0];
            sizes[i][0] = tmpMax;
        }
        if(tmpMax > maxVal)
            maxVal = tmpMax;
        if(tmpMax2 > maxVal2)
            maxVal2 = tmpMax2;
    }
    answer = maxVal * maxVal2;

    return answer;
}



// #include <string>
// #include <vector>
// #include <iostream>

// using namespace std;

// int solution(vector<vector<int>> sizes)
// {
//     int answer=0;

//     int w=0, h=0;
//     for(int i=0; i<sizes.size(); i++)
//     {
//         w=max(w,min(sizes[i][0],sizes[i][1]));
//         h=max(h,max(sizes[i][0],sizes[i][1]));
//     }
//     answer=w*h;

//     return answer;
// }