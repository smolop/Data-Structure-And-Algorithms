def merge_sort(v):

    if len(v) > 1:
        middle = len(v)//2
        L = v[:middle]
        R = v[middle:]

        merge_sort(L)
        merge_sort(R)

        merge(L, R, v)


def merge(L, R, merged_arr):
    i = j = k = 0
    while i < len(L) and j < len(R):
        if L[i] < R[j]:
            merged_arr[k] = L[i]
            i += 1
        else:
            merged_arr[k] = R[j]
            j += 1
        k += 1
    merge_remaining(merged_arr, L, R, i, j, k,)

    merged_arr


def merge_remaining(merged_arr, L, R, i, j, k,):
    for i in range(i, len(L)):
        merged_arr[k] = L[i]
        k += 1

    for j in range(j, len(R)):
        merged_arr[k] = R[i]
        k += 1


def main():
    array = [90, 10, 30, 20, 50, 40, 60, 80, 70]
    merge_sort(array)
    print(array)


if __name__ == '__main__':
    main()
    