#include <bits/stdc++.h> 
#include <cstdlib>

#define MAX  128

class Stack
{
private:
    int top;
    int stack[MAX];

public:
    
    Stack() { top = 0; }

    int push (int x);
    int pop();
    int peek();
    bool isFull();
    bool isEmpty();
    int size();
    void print();

    ~Stack() {}
};

int Stack::push(int x){
    return !isFull() ? stack[top++] = x : INT_MIN;
}

int Stack::pop(){
    if (isEmpty())
        return INT_MIN;
    int item = stack[--top];
    stack[top] = 0;  
    return item;
}

int Stack::peek(){
    if (isEmpty())
        return INT_MIN;
    return stack[top - 1];
}

bool Stack::isFull(){
    return size() == MAX;
}

bool Stack::isEmpty(){
    return size() == 0;
}

int Stack::size(){
    return top;
}

void Stack::print(){
    for (int i = 0; i < size(); i++)
        printf( "%s %d %s" , (i == 0 ? "[" : ""),   stack[i], (i < size() - 1 ? "," : "] \n")  );
}

int GetRand(int upper_bound){
    srand(time(0));
    int rnd = rand() % (int) upper_bound;
    std::cout << rnd << " " << upper_bound << std::endl;
    return rnd;
}

int main(int argc, char ** argv){
    Stack s;
    int r;
    for (int i = 1; i < 9; i++) 
	    s.push(i*10);
    s.print();
    r = GetRand(s.size());
    while( r != 0 && r != (int) (s.size()/2) ){
        if( r % 2 == 0)
            printf("pop: %d \n", s.pop());
        else
            printf("peek: %d \n", s.peek());
        s.print();
        r = GetRand(s.size());
    }
}