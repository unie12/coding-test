#include <stdio.h>
#include <map>
#include <iostream>

using namespace std;

int picture, recommend, number;
// begin, pair<first, second>, 숫자, pair<중복수, 순서>
map<int, pair<int, int>> m;

int main() {
    scanf("%d", &picture);
    scanf("%d", &recommend);

    for(int i=0; i<recommend; i++) {
        scanf("%d", &number);

        // 숫자 있으면 중복 추가
        if(m.find(number) != m.end())
            m[number].first++;
        // 틀 남았는데 숫자 없는 경우 틀에 추가
        else if(m.size() < picture)
            m.insert({number, {1, i}});
        // 틀 꽉 차 있고 숫자 없는 경우
        else{
            int num = 0, rec = 987654321, last = 987654321;

            for(auto& j : m) {
                // 중복수가 적거나, 중복수가 같은 경우 순서가 오래된 경우 찾기
                if(j.second.first < rec || (j.second.first == rec && j.second.second < last)) {
                    num = j.first; // key값
                    rec = j.second.first;
                    last = j.second.second;
                }
            }
            m.erase(num);
            m.insert({number, {1,i}});
        }
    }
    for(auto& i : m)
        cout << i.first << ' ';
}