class MergeSort(object):
    def __init__(self, arr):
        super(MergeSort, self).__init__()
        self.arr = arr

    def solve(self):
        self.__merge_sort(self.arr)

    def __merge_sort(self, arr):
        if len(arr) > 1:
            middle = len(arr) // 2

            L = arr[:middle]
            R = arr[middle:]

            self.__merge_sort(L)
            self.__merge_sort(R)

            self.__merge(arr, L, R)

    @staticmethod
    def __merge(arr, L, R):
        index_l = index_r = index_arr = 0
        while index_l < len(L) and index_r < len(R):
            if L[index_l] < R[index_r]:
                arr[index_arr] = L[index_l]
                index_l += 1
            else:
                arr[index_arr] = R[index_r]
                index_r += 1
            index_arr += 1

        for kth, ith in zip(range(index_arr, len(L)), range(index_l, len(L))):
            arr[kth] = L[ith]
        for kth, ith in zip(range(index_arr, len(R)), range(index_r, len(R))):
            arr[kth] = R[ith]


def get_instance(arr=[]):
    return MergeSort(arr=arr)
