package src.main;

public class BasicRatMaze {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private final int[][] BOARD;
    private final int DIM;
    private final int EMPTY_SPACE = 0;
    private final int LOCATION = 2;
    private final int EXIT = -1;

    public BasicRatMaze(int[][] board) {
        BOARD = board;
        DIM = board.length;
        board[DIM - 1][DIM - 1] = EXIT;
    }

    void solve() {
        System.out.println("Rat Maze:");
        if(findPath(0, 0))
            System.out.println("Solution: The rat found the exit.");
        else
            System.out.println(ANSI_RED + "There's a valid path." + ANSI_RESET);
        printBoard();
    }

    boolean findPath(int row, int col) {
        boolean verifyDown, verifyRight, verifyDiagonal;
        boolean verifyRow = row >= 0 && row < DIM;
        boolean verifyCol = col >= 0 && col < DIM;
        boolean isValid = verifyRow && verifyCol && BOARD[row][col] <= EMPTY_SPACE;

        printBoard();
        if (isValid){
            verifyDown = row < DIM - 1 && BOARD[row + 1][col] <= EMPTY_SPACE;
            verifyRight = col < DIM - 1 && BOARD[row][col + 1] <= EMPTY_SPACE;
            verifyDiagonal = row < DIM - 1 && col < DIM - 1 && BOARD[row + 1][col + 1] <= EMPTY_SPACE;
            if (BOARD[row][col] == EXIT) {
                BOARD[row][col] = LOCATION;
                return true;
            }
            markBlock(row, col);
            if (verifyDiagonal)
                if (findPath(row + 1, col + 1))
                    return true;
            if (verifyDown)
                if (findPath(row + 1, col))
                    return true;
            if (verifyRight)
                if (findPath(row, col + 1))
                    return true;
        }
        return false;
    }

    void markBlock(int row, int col) {
        int footprint = 3;
        if (BOARD[row][col] == EMPTY_SPACE)
            BOARD[row][col] = LOCATION;
        else if (BOARD[row][col] == LOCATION)
            BOARD[row][col] = footprint;
    }

    public void printBoard() {
        for (int r = 0; r < DIM; r++)
            for (int c = 0; c < DIM; c++)
                System.out.printf(" %s ", BOARD[r][c] + (c < DIM - 1 ? "" : "\n"));
    }

    public static int[][] getBoard() {
        int[][] boardEmpty =
                {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        int[][] board =
                {{0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 0}};

        return board;
    }

    public static void main(String[] args) {
        int[][] board = getBoard();
        new BasicRatMaze(board).solve();
    }
}