from sys import maxsize
from utils import get_cndtn

class Stack(object):

    def __init__(self, *args):
        super(Stack, self).__init__(*args)
        self.stack = []


    def is_empty(self):
        return not self.__len__() > 0

    
    def push(self, item):
        return self.stack.append(item)
    
    
    def pop(self):
        if (self.is_empty()):
            return (-maxsize - 1)
        return self.stack.pop()
    
    
    def peek(self):
        if (self.is_empty()):
            return (-maxsize - 1)
        return self.stack[self.__len__ - 1]


    def __str__(self):
        return "Stack: " + str(self.stack)


    def __len__(self):
        return len(self.stack)


def main():
    s = Stack()
    for i in range(10, 81, 10):
        s.push(i)
    print(s)
    b, r = get_cndtn(s)
    while b:
        if r % 2 == 0:
            s.pop()
        else:
            s.peek
        print(s)
        b, r = get_cndtn(s)


if __name__ == "__main__":
    main()