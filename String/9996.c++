#include <iostream>

using namespace std;
int n;
string str, pattern;
string front, rear;

int main() {

    cin >> n;
    cin >> pattern;

    int star = pattern.find("*");
    int patLen = pattern.length();

    front = pattern.substr(0, star);
    rear = pattern.substr(star+1, patLen - (star+1));
    // cout << front << "\n" << rear << "\n";

    for(int i=0; i<n; i++) {
        cin >> str;
        int len = str.length();
        int fIndex = str.find(front);
        int rIndex = str.rfind(rear);
        // cout << fIndex << " " << rIndex << "\n";
        // cout << len << " " << rear.length() << "\n";

        if(len < front.length() + rear.length()) {
            cout << "NE" << "\n";
            continue;
        }

        // if(fIndex == string::npos || rIndex == string::npos) {
        //     cout << "NE" << "\n";
        //     continue;
        // }
        // if(fIndex == 0 && rIndex == len - rear.length() && front.length() < rIndex) {
        //     cout << "DA" << "\n";
        // }
        // else {
        //     cout << "NE" << "\n";
        // }

        // 입력 문자열의 시작 부분이 패턴의 front와 일치하는지 확인
        string strFront = str.substr(0, front.length());
        // 입력 문자열의 끝 부분이 패턴의 rear와 일치하는지 확인
        string strRear = str.substr(len - rear.length(), rear.length());

        if(strFront == front && strRear == rear) {
            cout << "DA" << "\n";
        } else {
            cout << "NE" << "\n";
        }
    }
}