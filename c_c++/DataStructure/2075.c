#include <stdio.h>
#include <stdlib.h>

int arr[2250010];
int compare(const void*a, const void*b){
    if(*(int*)a > *(int*)b) return 1;
    else if(*(int*)a < *(int*)b) return -1;
    else return 0;
}

int main(){
    int n;
    scanf("%d", &n);
    for(int i=0; i<n*n; i++)
        scanf("%d", &arr[i]);

    qsort(arr, n*n, sizeof(int), compare);

    printf("%d", arr[n*n - n]);
    return 0;
}


/*
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int arr[2250010];
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;
    for (int i = 0; i < n * n; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr + n * n);
    cout << arr[n * n - n] << endl;
    return 0;
}
*/