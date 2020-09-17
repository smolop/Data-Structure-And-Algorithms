class NQueens(object):

    def __init__(self, matrix):
        super(NQueens, self).__init__()
        self.__matrix = matrix
        self.__N: int = len(matrix)

    def solve(self):
        print(f"{self.__N}Queens")
        self.__n_queens_solver(0)

    def __n_queens_solver(self, col: int) -> bool:
        if col >= self.__N:
            return True
        for row in range(0, self.__N):
            if self.__is_safe(row, col):
                self.__put_queen(row, col)
                if self.__n_queens_solver(col + 1):
                    return True
                self.__remove_queen(row, col)
        return False

    def __is_safe(self, row: int, col: int) -> bool:
        for c in range(0, self.__N):
            if self.__are_there_a_queen(row, c):
                return False
        # r up (from row to 0) : r-- and c left (from col to 0) : c--
        for r, c in zip(range(row, -1, -1), range(col, -1, -1)):
            if self.__are_there_a_queen(r, c):
                return False
        # r down (from row to N) : r++ and c left (from col to 0) : c--
        for r, c in zip(range(row, self.__N), range(col, -1, -1)):
            if self.__are_there_a_queen(r, c):
                return False
        return True

    def __put_queen(self, row: int, col: int):
        self.__matrix[row][col] = 1

    def __remove_queen(self, row: int, col: int):
        self.__matrix[row][col] = 0

    def __are_there_a_queen(self, row: int, col: int) -> bool:
        return self.__matrix[row][col] == 1


def get_instance(matrix: [[int], [int]]) -> NQueens:
    return NQueens(matrix=matrix)
