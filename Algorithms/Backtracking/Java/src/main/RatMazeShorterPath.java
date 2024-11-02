import java.util.concurrent.atomic.AtomicBoolean;

public class RatMazeShorterPath {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GRAY = "\u001B[90m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private final int[][] BOARD;
    private final int DIM;
    private final int EMPTY_SPACE = 0;
    private final int OBSTACLE = 1;
    private final int LOCATION = 8;
    private final int EXIT = -1;
    private int shorterPathCounter = 0;
    private java.util.Stack<Integer> shorterPathIndexStack;


    public RatMazeShorterPath(int[][] board) {
        BOARD = board;
        DIM = board.length;
        board[DIM - 1][DIM - 1] = EXIT;
    }


    void solve() {
        System.out.println("Rat Maze:");
        if (findPath(0, 0, 0)) { // pass stepCounter argument TODO
            System.out.println("Solution: The rat found the exit.");
        } else {
            BOARD[0][0] = LOCATION;
            System.out.println(ANSI_RED + "There's a valid path." + ANSI_RESET);
        }
        printBoard();
    }


    boolean findPath(int row, int col, int stepCounter) {
        if (isAValidPosition(row, col)) {
            stepCounter++;
            if (BOARD[row][col] == EXIT) {
                if (stepCounter <= shorterPathCounter || shorterPathCounter == 0){
                    shorterPathIndexStack = new java.util.Stack<Integer>();
                    shorterPathIndexStack.push(row);
                    shorterPathIndexStack.push(col);
                    shorterPathCounter = stepCounter;
                    return true;
                }
                return false;
            }
            return (auxFindPath(row, col, stepCounter));
        }
        return false;
    }


    private boolean auxFindPath(int row, int col, int stepCounter) {
        if (shorterPathCounter > 0)
            if (stepCounter >= shorterPathCounter - 1 || BOARD[row][col] == stepCounter)
                return false;
        if (stepCounter >= Math.pow(BOARD.length, 2))
            return false;
        java.util.Stack<Boolean> movesStack = new java.util.Stack<Boolean>();
        movesStack.push(moveDown(row, col, stepCounter));
        movesStack.push(moveRight(row, col, stepCounter));
        movesStack.push(moveUp(row, col, stepCounter));
        movesStack.push(moveLeft(row, col, stepCounter));
        movesStack.push(moveDiagonalDownRight(row, col, stepCounter));
        movesStack.push(moveDiagonalUpperRight(row, col, stepCounter));
        movesStack.push(moveDiagonalDownLeft(row, col, stepCounter));
        movesStack.push(moveDiagonalUpperLeft(row, col, stepCounter));

        while (!movesStack.isEmpty())// Get all valid paths. TODO
            if (movesStack.pop()) {
                if(BOARD[row][col] > stepCounter || BOARD[row][col] == EMPTY_SPACE)
                    BOARD[row][col] = stepCounter;
                if (shorterPathIndexStack.size() / 2 == shorterPathCounter - stepCounter) {
                    shorterPathIndexStack.push(row);
                    shorterPathIndexStack.push(col);
                }
            }
        return BOARD[row][col] == stepCounter;
    }


    private boolean isAValidPosition(int row, int col) {
        boolean verifyRow = row >= 0 && row < DIM;
        boolean verifyCol = col >= 0 && col < DIM;
        boolean verifyBlock = verifyRow && verifyCol;
        return  verifyBlock && BOARD[row][col] != OBSTACLE;
    }


    boolean moveUp(int row, int col, int stepCounter) {
        boolean verifyUp = row > 0 && BOARD[row - 1][col] != OBSTACLE;
        return verifyUp && findPath(row - 1, col, stepCounter);
    }


    boolean moveDown(int row, int col, int stepCounter){
        boolean verifyDown = row < DIM - 1 && BOARD[row + 1][col] != OBSTACLE;
        return verifyDown && findPath(row + 1, col, stepCounter);
    }


    boolean moveLeft(int row, int col, int stepCounter){
        boolean verifyLeft = col > 0 && BOARD[row][col - 1] != OBSTACLE;
        return verifyLeft && findPath(row, col - 1, stepCounter);
    }


    boolean moveRight(int row, int col, int stepCounter){
        boolean verifyRight = col < DIM - 1 && BOARD[row][col + 1] != OBSTACLE;
        return verifyRight && findPath(row, col + 1, stepCounter);
    }


    boolean moveDiagonalDownRight(int row, int col, int stepCounter){
        boolean verifyDiagonalDownRight = row < DIM - 1 && col < DIM - 1 && BOARD[row + 1][col + 1] != OBSTACLE;
        return verifyDiagonalDownRight && findPath(row + 1, col + 1, stepCounter);
    }


    boolean moveDiagonalUpperRight(int row, int col, int stepCounter){
        boolean verifyDiagonalUpperRight = row > 0 && col < DIM - 1 && BOARD[row - 1][col + 1] != OBSTACLE;
        return verifyDiagonalUpperRight && findPath(row - 1, col + 1, stepCounter);
    }


    boolean moveDiagonalDownLeft(int row, int col, int stepCounter){
        boolean verifyDiagonalDownLeft = row < DIM - 1 && col > 0 && BOARD[row + 1][col - 1] != OBSTACLE;
        return verifyDiagonalDownLeft && findPath(row + 1, col - 1, stepCounter);
    }


    boolean moveDiagonalUpperLeft(int row, int col, int stepCounter){
        boolean verifyDiagonalUpperLeft = row > 0 && col > 0 && BOARD[row - 1][col - 1] != OBSTACLE;
        return verifyDiagonalUpperLeft && findPath(row - 1, col - 1, stepCounter);
    }


    public void printBoard() {
        for (int r = 0; r < DIM; r++)
            for (int c = 0; c < DIM; c++)
                printBlock(r, c);
    }


    private void printBlock(int r, int c) {
        StringBuilder sb = new StringBuilder();
        setColorString(r, c, sb);
        sb.append(BOARD[r][c]).append(ANSI_RESET);
        if (c == DIM - 1) sb.append(r == DIM - 1 ? "\n\n" : "\n");
        System.out.printf(" %s ", sb.toString());
    }


    private void setColorString(int r, int c, StringBuilder sb) {
        if (BOARD[r][c] == EMPTY_SPACE)
            sb.append(ANSI_GRAY);
        else if (BOARD[r][c] == OBSTACLE && ( r != 0 || c != 0))
                sb.append(ANSI_BLUE);
        else if (BOARD[r][c] > OBSTACLE  && ( r != 0 || c != 0))
            sb.append(ANSI_YELLOW);
        else if (BOARD[r][c] == LOCATION)
            sb.append(ANSI_YELLOW);
    }


    public static int[][] getBoard() {
        int[][] emptyBoard8x8 =
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

        int[][] board8x8 =
                {
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 1, 1, 0, 0},
                        {0, 0, 1, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}
                };

        int [][] board10x10 =
                {
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };

        int [][] board12x12 =
                {
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1},
                        {0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1},
                        {0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
                };

        return board12x12;
    }


    public static void main(String[] args) {
        int[][] board = getBoard();
        new RatMazeShorterPath(board).solve();
    }
}
