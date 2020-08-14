#include <iostream>
#include <bits/stdc++.h> 
#include <cstdlib>

template <typename T>
class Queue{
private:
    int size, quantity, head, tail;
    T * queue;

    void Decrease();
	
	void Increase();

public:

    Queue(unsigned int size);

    bool IsEmpty();
    
    bool IsFull();
    
    T Enqueue(T item);
    
    T Dequeue();
    
    T Head();
    
    T Tail();
    
    void PrintQueue();

    ~Queue();
};


template <typename T>
Queue<T>::Queue(unsigned int size){
        quantity = head = 0;
        tail = -1;
        this->size = size;
        queue = new T[this->size];
}


template <typename T>
bool Queue<T>::IsEmpty(){
    return this->quantity == 0;
}


template <typename T>
bool Queue<T>::IsFull(){
    return this->quantity == this->size;
}


template <typename T>
void Queue<T>::Increase(){
    this->quantity++;
    this->tail = ++this->tail % this->size;
}


template <typename T>
void Queue<T>::Decrease(){
    this->quantity--;
    this->head = ++this->head % this->size;
}


template <typename T>
T Queue<T>::Enqueue(T item) {
    if (this->IsFull())
        return INT_MIN;
    this->Increase();
    queue[this->tail] = item;
    return item;
}


template <typename T>
T Queue<T>::Dequeue() {
    if (this->IsEmpty())
        return INT_MIN;
    int item = this->queue[this->head];
    this->queue[this->head] = 0;
    this->Decrease();
    return item;
}


template <typename T>
T Queue<T>::Head() {
    if (IsEmpty())
        return INT_MIN;
    return this->queue[this->head];
    }


template <typename T>    
T Queue<T>::Tail() {
    if (IsEmpty())
        return INT_MIN;
    return queue[this->tail];
}


template <typename T>   
void Queue<T>::PrintQueue() {
    for (int i = 0; i < this->size; i++)
        printf("%s %d %s", i == 0 ? "[" : ", ", queue[i], i < this->size - 1? "" : "]\n");
}


template <typename T>
Queue<T>::~Queue(){}


int GetRand(int upper_bound){
    srand(time(0));
    int rnd = rand() % (int) upper_bound;
    std::cout << rnd << " " << upper_bound << std::endl;
    return rnd;
}


int main(int argc, char ** args){
    int limit = 20;
    Queue<int> q(limit);
    for (int i = 1; i <= limit; i++)
        q.Enqueue(i*10);    
    q.PrintQueue();
    printf("Current head: %d \n", q.Head());
    printf("Current tail: %d \n", q.Tail());
    int from = 0;
    int to = GetRand(limit);
    if(to > 0){
        for (; from < to; from++)
            q.Dequeue();
        q.PrintQueue();
        printf("Current head: %d \n", q.Head());
        printf("Current tail: %d \n", q.Tail());
        from = GetRand(to);
        if (from < to){
            while (from++ < to)
                q.Enqueue(from * 11);
            q.PrintQueue();
            printf("Current head: %d \n", q.Head());
            printf("Current tail: %d \n", q.Tail());
        }
    }
    return 0;
}





	
	
	
	
	
	
	
	