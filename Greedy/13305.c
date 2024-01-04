#include <stdio.h>

int n;
long long roadLength[100001];
long long oilPrice[100001];

int main() {
    scanf("%d", &n);
    for(int i=0; i<n-1; i++)
        scanf("%lld", &roadLength[i]);

    for(int i=0; i<n; i++)
        scanf("%lld", &oilPrice[i]);

    long long price = roadLength[0] * oilPrice[0] ;
    long long min = price;
    for(int i=1; i<n; i++) {
        if(oilPrice[i-1] > oilPrice[i]) {
            price = roadLength[i] * oilPrice[i];
        }
        else {
            price = roadLength[i] * oilPrice[i-1];
            oilPrice[i] = oilPrice[i-1];
        }
        min += price;
        // printf("min = %d price = %d\n", min, price);
    }
    printf("%lld", min);
}