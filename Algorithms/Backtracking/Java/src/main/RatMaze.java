

public class RatMaze {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GRAY = "\u001B[90m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private final int[][] BOARD;
    private final int DIM;
    private final int EMPTY_SPACE = 0;
    private final int OBSTACLE = 1;
    private final int FOOTPRINT1 = 2;
    private final int FOOTPRINT2 = 3;
    private final int LOCATION = 8;
    private final int EXIT = -1;
    private int shorterPathCounter = 0;
    private int counterSteps = 0;

    public RatMaze(int[][] board) {
        BOARD = board;
        DIM = board.length;
        board[DIM - 1][DIM - 1] = EXIT;
    }

    void solve() {
        System.out.println("Rat Maze:");
        if (findPath(0, 0))
            System.out.println("Solution: The rat found the exit.");
        else
            System.out.println(ANSI_RED + "There's a valid path." + ANSI_RESET);
        printBoard();
    }

    boolean findPath(int row, int col) {// Clean code. TODO
        printBoard();
        if (isAValidPosition(row, col)) {
            counterSteps++;
            if (BOARD[row][col] == EXIT) {
                if (shorterPathCounter > counterSteps || shorterPathCounter == 0)
                    shorterPathCounter = counterSteps;
                BOARD[row][col] = LOCATION;
                counterSteps = 0;
                return true;
            }
            BOARD[row][col] = LOCATION;
            return (auxFindPath(row, col));
        }
        return false;
    }

    private boolean auxFindPath(int row, int col) {
        BOARD[row][col] = FOOTPRINT1;

        if (moveDiagonalDownRight(row, col))
            BOARD[row][col] = FOOTPRINT2;
        else if (moveDown(row, col))
            BOARD[row][col] = FOOTPRINT2;
        else if (moveRight(row, col))
            BOARD[row][col] = FOOTPRINT2;
        else if (moveDiagonalUpperRight(row, col))
            BOARD[row][col] = FOOTPRINT2;
        else if (moveUp(row, col))
            BOARD[row][col] = FOOTPRINT2;
        else if (moveDiagonalDownLeft(row, col))
            BOARD[row][col] = FOOTPRINT2;
        else if (moveLeft(row, col))
            BOARD[row][col] = FOOTPRINT2;
        else if (moveDiagonalUpperLeft(row, col))
            BOARD[row][col] = FOOTPRINT2;
        return BOARD[row][col] == FOOTPRINT2;
    }

    private boolean FindShorterPath(int row, int col) {
        java.util.Stack<Boolean> movesStack = new java.util.Stack<>();
        movesStack.push(moveDown(row, col));
        movesStack.push(moveRight(row, col));
        movesStack.push(moveUp(row, col));
        movesStack.push(moveLeft(row, col));
        movesStack.push(moveDiagonalDownRight(row, col));
        movesStack.push(moveDiagonalUpperRight(row, col));
        movesStack.push(moveDiagonalDownLeft(row, col));
        movesStack.push(moveDiagonalUpperLeft(row, col));

        if (BOARD[row][col] >= FOOTPRINT1)
            BOARD[row][col] = FOOTPRINT1;
        while (!movesStack.isEmpty())// Get all valid paths. TODO
            if (movesStack.pop())
                BOARD[row][col] = FOOTPRINT2;
        return BOARD[row][col] == FOOTPRINT2;
    }

    private boolean isAValidPosition(int row, int col) {
        boolean verifyRow = row >= 0 && row < DIM;
        boolean verifyCol = col >= 0 && col < DIM;
        boolean verifyBlock = verifyRow && verifyCol;
        return  verifyBlock && BOARD[row][col] <= EMPTY_SPACE;
    }

    boolean moveUp(int row, int col) {
        boolean verifyUp = row > 0 && BOARD[row - 1][col] <= EMPTY_SPACE;
        return verifyUp && findPath(row - 1, col);
    }

    boolean moveDown(int row, int col){
        boolean verifyDown = row < DIM - 1 && BOARD[row + 1][col] <= EMPTY_SPACE;
        return verifyDown && findPath(row + 1, col);
    }

    boolean moveLeft(int row, int col){
        boolean verifyLeft = col > 0 && BOARD[row][col - 1] <= EMPTY_SPACE;
        return verifyLeft && findPath(row, col - 1);
    }

    boolean moveRight(int row, int col){
        boolean verifyRight = col < DIM - 1 && BOARD[row][col + 1] <= EMPTY_SPACE;
        return verifyRight && findPath(row, col + 1);
    }

    boolean moveDiagonalDownRight(int row, int col){
        boolean verifyDiagonalDownRight = row < DIM - 1 && col < DIM - 1 && BOARD[row + 1][col + 1] <= EMPTY_SPACE;
        return verifyDiagonalDownRight && findPath(row + 1, col + 1);
    }

    boolean moveDiagonalUpperRight(int row, int col){
        boolean verifyDiagonalUpperRight = row > 0 && col < DIM - 1 && BOARD[row - 1][col + 1] <= EMPTY_SPACE;
        return verifyDiagonalUpperRight && findPath(row - 1, col + 1);
    }

    boolean moveDiagonalDownLeft(int row, int col){
        boolean verifyDiagonalDownLeft = row < DIM - 1 && col > 0 && BOARD[row + 1][col - 1] <= EMPTY_SPACE;
        return verifyDiagonalDownLeft && findPath(row + 1, col - 1);
    }

    boolean moveDiagonalUpperLeft(int row, int col){
        boolean verifyDiagonalUpperLeft = row > 0 && col > 0 && BOARD[row - 1][col - 1] <= EMPTY_SPACE;
        return verifyDiagonalUpperLeft && findPath(row - 1, col - 1);
    }

    public void printBoard() {
        for (int r = 0; r < DIM; r++)
            for (int c = 0; c < DIM; c++)
                System.out.printf(" %s ", getBlockString(r, c));
    }

    private String getBlockString(int r, int c) {
        StringBuilder sb = new StringBuilder();
        setColorString(r, c, sb);
        sb.append(BOARD[r][c]).append(ANSI_RESET);
        if (c == DIM - 1) sb.append(r == DIM - 1 ? "\n\n" : "\n");
        return sb.toString();
    }

    private void setColorString(int r, int c, StringBuilder sb) {
        if (BOARD[r][c] == EMPTY_SPACE)
            sb.append(ANSI_GRAY);
        else if (BOARD[r][c] == OBSTACLE)
            sb.append(ANSI_BLUE);
        else if (BOARD[r][c] == FOOTPRINT1)
            sb.append(ANSI_BRIGHT_YELLOW);
        else if (BOARD[r][c] == FOOTPRINT2)
            sb.append(ANSI_YELLOW);
        else if (BOARD[r][c] == LOCATION)
            sb.append(ANSI_GREEN);
    }

    public static int[][] getBoard() {
        int[][] boardEmpty =
                {
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}
                };

        int[][] board =
                {{0, 0, 1, 0},
                        {0, 1, 1, 1},
                        {0, 1, 1, 1},
                        {1, 0, 0, 0}};

        return new int[][]
                {
                        {0, 1, 1, 0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1, 1, 0, 1},
                        {1, 0, 1, 1, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0, 1, 1, 0},
                        {0, 1, 1, 1, 1, 0, 1, 0},
                        {1, 0, 0, 0, 0, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}
                };
    }

    public static void main(String[] args) {
        int[][] board = getBoard();
        new RatMaze(board).solve();
    }
}