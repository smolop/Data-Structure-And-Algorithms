
def partition(arr, lower_bound, upper_bound):

    pivot = arr[upper_bound]
    lb_idx = lower_bound
    for j in range(lb_idx, upper_bound):
        if arr[j] < pivot:
            arr[lb_idx], arr[j] = arr[j], arr[lb_idx]
            lb_idx += 1
        
    arr[lb_idx], arr[upper_bound] = arr[upper_bound], arr[lb_idx]
    return lb_idx


def quick_sort(arr, lower_bound, upper_bound):
    if lower_bound < upper_bound:

        pivot_index = partition(arr, lower_bound, upper_bound)

        quick_sort(arr, lower_bound, pivot_index - 1)
        quick_sort(arr, pivot_index + 1, upper_bound)


def main():
    vector = [90, 10, 30, 20, 50, 40, 60, 80, 70]
    lower_bound = 0
    upper_bound = len(vector) - 1
    quick_sort(vector, lower_bound, upper_bound)
    print(vector)


if __name__ == "__main__":
    main()