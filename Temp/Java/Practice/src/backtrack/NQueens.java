package backtrack;

public class NQueens {

	private int[][] matrix;
	private int N;
	
	public NQueens(int[][] matrix){
		this.matrix = matrix;
		this.N = matrix.length;
	}
	
	public void solve() {
		System.out.printf("%sQueens\n", N);
		nQueensSolver(0);
	}

	private boolean nQueensSolver(int col) {
		if (col >= N)
			return true;
		for (int row = 0; row < N; row++) 
			if(isSafe(row, col)) {
				matrix[row][col] = 1;
				if(nQueensSolver(col + 1))
					return true;
				matrix[row][col] = 0;
			}
		return false;
	}

	private boolean isSafe(int row, int col) {
		for (int c = 0; c < N; c++)
			if(matrix[row][c] == 1)
				return false;
		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--)
			if(matrix[r][c] == 1)
				return false;
		for (int r = row, c = col; r < N && c >= 0; r++, c--)
			if(matrix[r][c] == 1)
				return false;
		return true;
	}
	
}
