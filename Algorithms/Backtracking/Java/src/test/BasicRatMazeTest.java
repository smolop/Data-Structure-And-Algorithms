package src.test;


public class BasicRatMazeTest {
    private final int LOCATION = 2;
    private src.main.BasicRatMaze basicRatMaze;


    @org.junit.jupiter.api.BeforeEach
    public void setUp(){
        basicRatMaze = new src.main.BasicRatMaze(src.main.BasicRatMaze.getNewBoard());
    }


    @org.junit.jupiter.api.Test
    void markBlockTest01(){
        int[][] expectedBoard = src.main.BasicRatMaze.getNewBoard();
        expectedBoard[1][1] = LOCATION;
        basicRatMaze.markBlock(1,1);
        org.junit.jupiter.api.Assertions.assertArrayEquals(expectedBoard, src.main.BasicRatMaze.getBoard());
    }


    @org.junit.jupiter.api.Test
    void markBlockTest02(){
        int[][] expectedBoard = src.main.BasicRatMaze.getNewBoard();
        expectedBoard[1][1] = LOCATION;
        expectedBoard[0][2] = LOCATION;
        basicRatMaze.markBlock(1,1);
        basicRatMaze.markBlock(0,2);
        org.junit.jupiter.api.Assertions.assertArrayEquals(expectedBoard, src.main.BasicRatMaze.getBoard());
    }


    @org.junit.jupiter.api.Test
    void markBlockTest03(){
        int[][] expectedBoard = src.main.BasicRatMaze.getNewBoard();
        expectedBoard[1][1] = LOCATION;
        expectedBoard[0][2] = LOCATION;
        basicRatMaze.markBlock(1,1);
        basicRatMaze.markBlock(0,2);
        org.junit.jupiter.api.Assertions.assertArrayEquals(expectedBoard, src.main.BasicRatMaze.getBoard());
    }


    @org.junit.jupiter.api.Test
    void moveDiagonalTest(){
        org.junit.jupiter.api.Assertions.assertTrue(basicRatMaze.moveDiagonal(2, 2));
    }


    @org.junit.jupiter.api.Test
    void moveRightTest(){
        org.junit.jupiter.api.Assertions.assertTrue(basicRatMaze.moveRight(3, 2));
    }


    @org.junit.jupiter.api.Test
    void moveDownTest(){
        org.junit.jupiter.api.Assertions.assertTrue(basicRatMaze.moveDown(2, 3));
    }


    void printBoard(int[][] board){
        int dim = board.length;
        for (int[] ints : board)
            for (int c = 0; c < dim; c++)
                System.out.printf(" %s ", ints[c] + (c < dim - 1 ? "" : "\n"));
    }

}
