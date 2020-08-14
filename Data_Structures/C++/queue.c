#include <stdio.h>
#include <stdlib.h>
#include <time.h>
//#include <bits/stdc++.h>
#include <limits.h>

struct Queue
{
    unsigned size;
    int quanitity;
    int first;
    int last;
    int * queue;
};

struct Queue * Queue(unsigned size){
    struct Queue * Q = (struct Queue *) malloc(sizeof(struct Queue));
    Q->size = size;
    Q->queue = (int *) malloc(Q->size * sizeof(int));
    Q->quanitity = 0;
    Q->first = 0;
    Q->last = -1;
    return Q;
};

int is_empty(struct Queue * Q){
    return Q->quanitity == 0;
}

int is_full(struct Queue * Q){
    return Q->quanitity == Q->size;
}

void increase(struct Queue * Q){
    Q->quanitity++;
    Q->last = ++Q->last % Q->size;
}

void decrease(struct Queue * Q){
    Q->quanitity--;
    Q->first = ++Q->first % Q->size;
}

int enqueue(struct Queue * Q, int item){
    if (is_full(Q))
        return INT_MIN;
    increase(Q);
    Q->queue[Q->last] = item;
    return item;
}

int dequeue(struct Queue * Q){
    if (is_empty(Q))
        return INT_MIN;
    int item = Q->queue[Q->first];
    Q->queue[Q->first] = 0;
    decrease(Q);
    return item;
}

int head(struct Queue * Q){
    if (is_empty(Q))
        return INT_MIN;
    return Q->queue[Q->first];
}

int tail(struct Queue * Q){
    if (is_empty(Q))
        return INT_MIN;
    return Q->queue[Q->last];
}

void print_queue(struct Queue * Q){
    for (int i = 0; i < Q->size; i++)
        printf("%s %d %s", i == 0 ? "[" : "", Q->queue[i], i < Q->size - 1 ? "," : "]\n");
}

int main (int argc, char ** argv){
    int limit = 20;
    struct Queue * Q = Queue(limit);
    for (int i = 1; i <= limit; i++)
        enqueue(Q, i);
    print_queue(Q);
    printf("First P: %d Head: %d\n", Q->first, head(Q));
    printf("Last P: %d Tail: %d\n", Q->last, tail(Q));
    for (int i = 1; i <= (limit + (int) (limit /2)); i++){
        if(i <= limit)
            dequeue(Q);
        if (i > limit + 1 && i % 3 == 0)
            dequeue(Q);
        else if( i > limit )
            enqueue(Q, i+200);
        else if( i % 2 == 0)
            enqueue(Q, i+100);
        if (i == limit + 1){
            print_queue(Q);
            printf("First P: %d Head: %d\n", Q->first, head(Q));
            printf("Last P: %d Tail: %d\n", Q->last, tail(Q));
        }
        
    }
    print_queue(Q);
    printf("First P: %d Head: %d\n", Q->first, head(Q));
    printf("Last P: %d Tail: %d\n", Q->last, tail(Q));
    return 0;
}
