//#include <bits/stdc++.h> 
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <limits.h>

struct Stack
{
    int top;
    unsigned size;
    int * stack;
};

struct Stack * Stack(unsigned size){
    struct Stack * s = (struct Stack *) malloc(sizeof(struct Stack));
    s->size = size;
    s->top = 0;
    s->stack = (int *) malloc(s->size * sizeof(int));
    return s;
};

int is_empty(struct Stack *  s){
    return s->top == 0;
}

int is_full(struct Stack * s){
    return s->top == s->size;
}

int push(struct Stack * s, int item){
    if (is_full(s))
        return INT_MIN;
    s->stack[s->top++] = item;
    return item;
}

int pop(struct Stack * s){
    if (is_empty(s))
        return INT_MIN;
    int item = s->stack[--s->top];
    s->stack[s->top] = 0;
    return item;
}

int peek(struct Stack * s){
    if (is_empty(s))
        return INT_MIN;
    return s->stack[s->top - 1];
}

void printStack(struct Stack * s){
    for (int i = 0; i < s->size; i++)
        printf("%s %d %s", i == 0 ? "[" : "",s->stack[i], i < s->size - 1 ? "," : "]\n");
}

int is_in(int x, int arr[]){
    int size = sizeof(&arr) / sizeof(int);
    for (int i = 0; i < size; i++ )
        if (x == arr[i])
            return 0;
    return -1;
}

int get_rand(int upper_bound, int n){
    int rnd = rand() % (int) upper_bound;
    int arr[] = {7, 9, 10, 13, 18, n};
    while (is_in(rnd, arr) == 0) {
        srand(time(NULL));
        rnd = rand() % (int) upper_bound;
    }
    printf("rnd: %d - ub: %d\n", rnd, upper_bound);
    return rnd;
}

int main(int argc, char ** argv){
    struct Stack * s = Stack(20);
    for (int i = 1; i <= s->size; i++)
        push(s, i*10);
    printStack(s);
    int r = get_rand(s->size, -1);
    while ( r != (int) (s->size/2) && r != 0)
    {
        if(r % 2 == 0)
            printf("Pop: %d \n", pop(s));
        else
            printf("Peek: %d \n", peek(s));
        r = get_rand(s->size, r);
    }
    printStack(s);
    return 0;
}


