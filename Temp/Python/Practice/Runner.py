from Practice.Backtrack import NQueens
from Practice.Sort import InsertionSort, MergeSort, QuickSort

import numpy as np


class Runner(object):
    def __init__(self, *args):
        super(Runner, self).__init__(*args)

    @staticmethod
    def run_insertion_sort(arr):
        InsertionSort.get_instance(arr=arr).solve()

    @staticmethod
    def run_merge_sort(arr):
        MergeSort.get_instance(arr=arr).solve()

    @staticmethod
    def run_quick_sort(arr):
        QuickSort.get_instance(arr=arr).solve()

    @staticmethod
    def run_n_queens_backtrack(matrix: [[int], [int]]):
        NQueens.get_instance(matrix=matrix).solve()


def get_arr() -> [int]:
    return [20, 40, 10, 60, 20, 30, 50, 70, 80]


def get_matrix(dim: int) -> [[int], [int]]:
    return np.zeros(shape=(dim, dim))


def main(option=0):
    print(f"Running...")
    dimension: int = 8
    arr: [int] = get_arr()
    mtx: [[int], [int]] = get_matrix(dimension)
    runner: Runner = Runner()

    if option == 1:
        runner.run_insertion_sort(arr=arr)
    elif option == 2:
        runner.run_merge_sort(arr=arr)
    elif option == 3:
        runner.run_quick_sort(arr=arr)
    elif option == 4:
        runner.run_n_queens_backtrack(matrix=mtx)
    else:
        print("Invalid option")

    if 0 < option < 4:
        print(arr)
    elif option == 4:
        print(mtx)


if __name__ == '__main__':
    main(option=4)
