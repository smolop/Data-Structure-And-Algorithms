def swap(array, index_i, min_index):
    array[index_i], array[min_index] = array[min_index], array[index_i]


def selection_sort(array=[]):
    for index_i in range(len(array)):
        min_index = index_i
        for index_j in range(index_i + 1, len(array)):
            if array[index_j] < array[min_index]:
                min_index = index_j

        swap(array, index_i, min_index)
    print(array)


def main():
    array = [9, 3, 4, 6, 7, 8, 1, 2, 5, 10]
    selection_sort(array=array)


if __name__ == '__main__':
    main()
