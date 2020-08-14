
from sys import maxsize
from utils import get_cndtn

class Queue(object):
    def __init__(self, *args, **kwargs):
        self.size = kwargs['size']
        self.queue = [None]*self.size
        self.quantity = 0
        self.head = 0
        self.tail = -1
    
    
    def __increase(self):
        self.quantity = self.quantity + 1
        self.tail = (self.tail + 1) % self.size
    #    print(f"Quantity: {self.quantity}")
        print(f"Tail: {self.tail}")
    
    
    def __decrease(self):
        self.quantity = self.quantity - 1
        self.head = (self.head + 1) % self.size
    #    print(f"Quantity: {self.quantity}")
        print(f"Head: {self.head}")


    def is_full(self):
        return self.quantity == self.size
    

    def is_empty(self):
        return self.quantity == 0


    def enqueue(self, item):
        if self.is_full():
            return (-maxsize - 1)
        self.__increase()
        self.queue[self.tail] = item 
        return item
    

    def dequeue(self):
        if self.is_empty():
            return (-maxsize - 1)
        item = self.queue[self.head]
        self.queue[self.head] = None
        self.__decrease()
        # print(f"Item dequeued: {item}")
        return item
    

    def head(self):
        return self.queue[self.head]
    

    def tail(self):
        return self.queue[self.tail]


    def __str__(self):
        return str(self.queue)

    
    def __len__(self):
        return len(self.queue)


def main():
    queue = Queue(size=20)
    for i in range(1, 21):
        queue.enqueue(i*10)
    print(queue)
    b, _ = get_cndtn(queue)
    i = 0
    while b :
        print(f"Item dequeued: {queue.dequeue()}")
        print(f"Current head: {queue.head}")
        b, _ = get_cndtn(queue)
        i += 1 
    print(queue) 
    print(f"i: {i}")
    for j in range(1, i): 
        queue.enqueue(j*11)
    print(queue) 

if __name__ == "__main__":
    main()