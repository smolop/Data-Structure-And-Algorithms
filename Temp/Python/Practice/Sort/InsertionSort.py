
class InsertionSort(object):
    def __init__(self, arr):
        super(InsertionSort, self).__init__()
        self.arr = arr
        self.N = len(arr)

    def solve(self):
        print(f"Insertion Sort:")
        self.__insertion_sort()

    def __insertion_sort(self):
        for index in range(1, self.N - 1, 1):
            key = self.arr[index]
            index_j = index - 1
            while index_j >= 0 and key < self.arr[index_j]:
                self.arr[index_j + 1] = self.arr[index_j]
                index_j -= 1
            self.arr[index_j + 1] = key


def get_instance(arr=[]):
    return InsertionSort(arr=arr)