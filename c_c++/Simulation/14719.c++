#include <stdio.h>
#include <iostream>
#include <vector>

using namespace std;
int h, w;
int water;

int main() {
    scanf("%d %d", &h, &w);
    vector<int> height(w);

    for(int i=0; i<w; i++) {
        scanf("%d", &height[i]);
    }

    for(int i=1; i<w-1; i++) {
        int left =0, right = 0;

        for(int j=0; j<i; j++)
            left = max(left, height[j]);
        for(int j=w-1; j>i; j--)
            right = max(right, height[j]);
        water += max(0, min(left, right) - height[i]);
        // printf("left: %d right: %d water: %d\n", left, right, water);
    }

    printf("%d", water);
}