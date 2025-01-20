#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <math.h>
#include <iostream>

using namespace std;

bool isPrime(int n) {
    if(n < 2)
        return false;
    for(int i=2; i<= sqrt(n); ++i) {
        if(n%i == 0)
            return false;
    }
    // cout << "true: " << n << "\n"; 
    return true;
}

int solution(string numbers) {
    int answer = 0;
    set<int> v{};

sort(numbers.begin(), numbers.end());
    do{
        string tmp;
        for(int i=0; i<numbers.size(); i++) {
            tmp += numbers[i];
            if(isPrime(stoi(tmp)))
                v.insert(stoi(tmp));
            // cout << tmp << "\n";
        }
        // cout << "for end\n";
    }while(next_permutation(numbers.begin(), numbers.end()));
       
    answer = v.size();
    return answer;
}

int main() {
    solution("011");
}