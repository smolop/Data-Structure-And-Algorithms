class QuickSort(object):
    def __init__(self, arr=[]):
        super(QuickSort, self).__init__()
        self.arr = arr

    def solve(self):
        self.__quick_sort(self.arr, 0, len(self.arr) - 1)

    def __quick_sort(self, arr, lower_bound, upper_bound):
        if lower_bound < upper_bound:
            pivot_index = self.__partition(arr, lower_bound, upper_bound)

            self.__quick_sort(arr, lower_bound, pivot_index - 1)
            self.__quick_sort(arr, pivot_index + 1, upper_bound)

    @staticmethod
    def __partition(arr, lower_bound, upper_bound):
        pivot = arr[upper_bound]
        lth = lower_bound
        for ith in range(lth, upper_bound):
            if arr[ith] < pivot:
                arr[ith], arr[lth] = arr[lth], arr[ith]
                lth += 1
        arr[lth], arr[upper_bound] = arr[upper_bound], arr[lth]
        return lth


def get_instance(arr=[]):
    return QuickSort(arr=arr)
