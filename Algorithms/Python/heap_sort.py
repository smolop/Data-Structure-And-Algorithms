
def heapify(arr, last, largest):
    print(arr)

    left = (2 * largest) + 1
    right = (2 * largest) + 2

    new_largest = largest

    print(f"nl: {new_largest}")

    if left < last and arr[new_largest] < arr[left]:
        print(f"nl-l: {left}")
        new_largest = left

    if right < last and arr[new_largest] < arr[right]:
        print(f"nl-r: {right}")
        new_largest = right

    if new_largest != largest:
        arr[largest], arr[new_largest] = arr[new_largest], arr[largest]
        print(f"l: {arr[largest]}, nl: {arr[new_largest]}")
        print(arr)
        heapify(arr, last, new_largest)


def heap_sort(arr):

    last = len(arr)
    # from last/2 - 1 to i >= 0
    for i in range((last // 2) - 1, -1, -1):
        heapify(arr, last, i)
    # from last - 1 to i > 0
    print(f"###########")

    for i in range(last - 1, 0, -1): 
        arr[i], arr[0] = arr[0], arr[i]
        print(f"i: {i}, : {0}")
        heapify(arr, i, 0)


def main():
    arr = [90, 10, 30, 20, 50, 40, 60, 80, 70]
    heap_sort(arr)
    print(arr)


if __name__ == '__main__':
    main()
    