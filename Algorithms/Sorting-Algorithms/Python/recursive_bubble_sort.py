
def recursive_bubble_sort(array):
    for index in range(0, len(array) - 1):
        if array[index] > array[index+1]:
            swap(array, index)
            return recursive_bubble_sort(array)

def swap(array, index):
    array[index], array[index+1] = array[index+1], array[index]

def main():
    list = [90, 10, 30, 20, 50, 40, 60, 80, 70]
    recursive_bubble_sort(list)
    print(list)

if __name__ == '__main__':
    main()
    