import numpy as np


class NQueens(object):
    def __init__(self, matrix):
        super(NQueens, self).__init__()
        self.matrix = matrix
        self.N = len(matrix)

    def solve(self):
        print(f"{self.N}Queens")
        self.__n_queens_solver(0)

    def __n_queens_solver(self, col):
        if col >= self.N:
            return True
        for row in range(self.N):
            if self.__is_safe(row, col):
                self.__put_queen(row, col)
                if self.__n_queens_solver(col + 1):
                    return True
                self.__remove_queen(row, col)
        return False

    def __is_safe(self, row, col):
        for c in range(self.N):
            if self.__is_there_a_queen(c, row):
                return False
        for r, c in zip(range(row, -1, -1), range(col - 1, -1, -1)):
            if self.__is_there_a_queen(c, r):
                return False
        for c, r in zip(range(row, self.N), range(col, -1, -1)):
            if self.__is_there_a_queen(c, r):
                return False
        return True

    def __is_there_a_queen(self, c, row):
        return self.matrix[row][c] == 1

    def __put_queen(self, row, col):
        self.matrix[row][col] = 1

    def __remove_queen(self, row, col):
        self.matrix[row][col] = 0


def main():
    N = 8
    matrix = np.zeros([N, N])
    nq = NQueens(matrix=matrix)
    nq.solve()
    print(matrix)


if __name__ == '__main__':
    main()
