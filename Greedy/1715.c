#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int value;
}Que;

typedef struct {
    Que que[100001];
    int size;
} PriorityQue;

int n;

void insert(PriorityQue *q, Que item) {
    int i;
    i = ++(q->size);

    while((i != 1) && (item.value < q->que[i/2].value)) {
        q->que[i] = q->que[i/2];
        i /= 2;
    }
    q->que[i] = item;
    // printf("insert val : %d\n", item.value);
}

Que delete_element(PriorityQue *q) {
    int parent, child;
    Que item, temp;

    item = q->que[1];
    temp = q->que[(q->size)--];
    parent = 1;
    child = 2;

    while(child <= q->size) {
        if((child < q->size) && (q->que[child].value > q->que[child+1].value))
            child++;
        if(temp.value <= q->que[child].value) break;

        q->que[parent] = q->que[child];
        parent = child;
        child *= 2;
    }
    q->que[parent] = temp;
    return item;
}

int main() {
    Que tmpQue;
    scanf("%d", &n);

    PriorityQue que;
    que.size = 0;

    for(int i=0; i<n; i++) {
        scanf("%d", &tmpQue.value);
        insert(&que, tmpQue);
    }

    int result = 0;
    int print = 0;
    for(int i=0; i<n-1; i++) {
        int tmp1, tmp2;
        tmp1 = delete_element(&que).value;
        tmp2 = delete_element(&que).value;
        result = tmp1 + tmp2;
        print = print + result;
        // printf("tmp1 : %d tmp2 : %d result : %d\n", tmp1, tmp2, result);

        tmpQue.value = result;
        insert(&que, tmpQue);
    }
    printf("%d", print);

}