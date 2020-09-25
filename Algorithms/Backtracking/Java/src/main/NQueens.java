package src.main;

public class NQueens {

	private int matrix[][] = null;

	public NQueens(int[][] matrix) {
		this.matrix = matrix;
	}

	boolean isSafe(int row, int col) {
		int N = matrix.length;

		for (int c = 0; c < N; c++)
			if (matrix[row][c] == 1)
				return false;

		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--)
			if (matrix[r][c] == 1)
				return false;

		for (int r = row, c = col; r < N && c >= 0; r++, c--)
			if (matrix[r][c] == 1)
				return false;

		return true;
	}

	boolean solver(int col){
		int N = matrix.length;
		if (col >= N)
			return true;
		
		for (int r = 0; r < N; r++) 
			if (isSafe(r, col)){
				matrix[r][col] = 1;
				if (solver(col + 1))
					return true;
				matrix[r][col] = 0;
			}
		return false;
	}
	
	void printMatrix() {
		int N = matrix.length;
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				System.out.printf(" %s ", matrix[r][c] + (c == N - 1 ? "\n" : "") );
	}

	public static void main(String[] args) {
		int N = 8;
		int[][] matrix = new int[N][N];
		NQueens nq = new NQueens(matrix);
		nq.solver(0);
		nq.printMatrix();
	}

}
