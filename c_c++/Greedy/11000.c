#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int start;
    int end;
}Que;

Que que[200001];
int heap[200001];
int heap_size = 0;

int front, rear;
int n;
int room;

void push(int value){
    int current = ++heap_size;
    while(current != 1  && heap[current/2] > value) {
        heap[current] = heap[current/2];
        current /= 2;
    }
    heap[current] = value;
}

int pop(){
    int ret = heap[1];
    int last_value = heap[heap_size--];
    int parent = 1;
    int child = 2;
    while(child <= heap_size) {
        if(child < heap_size && heap[child] > heap[child +1]) child++;
        if(last_value <= heap[child]) break;
        heap[parent] = heap[child];
        parent = child;
        child *= 2;
    }
    heap[parent] = last_value;
    return ret;
}
int compare(const void* a, const void *b){
    Que* tmp1 = (Que*)a;
    Que* tmp2 = (Que*)b;

    if(tmp1->start > tmp2->start)
        return 1;
    else if(tmp1->start < tmp2->start)
        return -1;
    else{
        if(tmp1->end > tmp2->end)
            return 1;
        return -1;
    }
}

int main(){
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d %d", &que[rear].start, &que[rear].end);
        rear++;
    }
    qsort(que, n, sizeof(Que), compare);

    for(int i=0; i<n; i++){
        push(que[i].end);
        if(heap[1] <= que[i].start && heap_size != 0)
            pop();
    }
    printf("%d", heap_size);
    return 0;
}