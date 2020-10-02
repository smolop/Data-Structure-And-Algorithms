package src.main;


public class BasicRatMaze {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static int[][] BOARD;
    private final int DIM;
    private final int EMPTY_SPACE = 0;
    private final int LOCATION = 2;
    private final int EXIT = -1;

    public BasicRatMaze(int[][] board) {
        BOARD = board;
        DIM = board.length;
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
        boolean verifyRow = row >= 0 && row < DIM;
        boolean verifyCol = col >= 0 && col < DIM;
        boolean isValid = verifyRow && verifyCol && BOARD[row][col] <= EMPTY_SPACE;

        if (isValid){
            if (BOARD[row][col] == EXIT)
                return true;
            markBlock(row, col);
            if (!moveDiagonal(row, col))
                if(!moveDown(row, col))
                    if(!moveRight(row, col))
                        return false;
        }
        return true;
    }

    public boolean moveRight(int row, int col) {
        boolean verifyRight = col < DIM - 1 && BOARD[row][col + 1] <= EMPTY_SPACE;
        return  verifyRight && findPath(row, col + 1);
    }


    public boolean moveDiagonal(int row, int col) {
        boolean verifyDiagonal = row < DIM - 1 && col < DIM - 1 && BOARD[row + 1][col + 1] <= EMPTY_SPACE;
        return verifyDiagonal && findPath(row + 1, col + 1);
    }


    public boolean moveDown(int row, int col) {
        boolean verifyDown = row < DIM - 1 && BOARD[row + 1][col] <= EMPTY_SPACE;
        return verifyDown && findPath(row + 1, col);
    }


    public void markBlock(int row, int col) {
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
        return BOARD;
    }


    public static int[][] getNewBoard() {
        int[][] emptyBoard =
                {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, -1}};

        int[][] board =
                {{0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 1},
                {1, 1, 0, -1}};

        return board;
    }


    public static void main(String[] args) {
        int[][] board = getNewBoard();
        new BasicRatMaze(board).solve();
    }
}