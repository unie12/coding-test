#include <stdio.h>

int n;
int arr[101];
int operators[4];
int min=1000000001, max=-1000000001;

void func(int value, int indx) {
    if(indx == n) {
        if(value > max)
            max = value;
        if(value < min)
            min = value;
    }
    
    for(int i=0; i<4; i++) {
        if(operators[i] > 0) {
            operators[i]--;
            if(i == 0) {
                func(value + arr[indx], indx+1);
            }
            else if(i == 1) {
                func(value - arr[indx], indx+1);
            }
            else if(i == 2) {
                func(value * arr[indx], indx+1);
            }
            else {
                func(value / arr[indx], indx+1);
            }
            operators[i]++;
        }
    }

}

int main() {
    scanf("%d", &n);
    
    for(int i=0; i<n; i++)
        scanf("%d", &arr[i]);
    // [0] = 덧셈, [1] = 뺄셈, [2] = 곱셈, [3] = 나눗셈
    for(int i=0; i<4; i++)
        scanf("%d", &operators[i]);

    func(arr[0], 1);
    printf("%d\n%d", max, min);
}