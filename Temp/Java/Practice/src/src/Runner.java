package src;


public class Runner {

	void printArr(int[] arr) {
		int N = arr.length;
		for (int i = 0; i < N; i++)
			System.out.printf(" %s ", arr[i]);
	}
	
	void printMtx(int[][] mtx) {
		int N = mtx.length;
		for (int row = 0; row < N; row++)
			for (int col = 0; col < N; col++)
				System.out.printf(" %s ", mtx[row][col] + (col == N - 1 ? "\n" : ""));
	}
	
	void execInsertionSort(int[] arr){
		sort.InsertionSort insertionSort = new sort.InsertionSort(arr);  
		insertionSort.solve();
		printArr(arr);
	}
	
	void execMergeSort(int[] arr) {
		sort.MergeSort mergeSort = new sort.MergeSort(arr);
		mergeSort.solve();
		printArr(arr);
	}
	
	void execQuickSort(int[] arr) {
		sort.QuickSort quickSort = new sort.QuickSort(arr);
		quickSort.solve();
		printArr(arr);
	}
	
	void execNQueens() {
		int N = 8;
		int[][] mtx = new int[N][N];
		backtrack.NQueens nQueens = new backtrack.NQueens(mtx);
		nQueens.solve();
		printMtx(mtx);
	}
	
	public static void main(String[] args) {
		Runner runner = new Runner();
		int[] arr = {20, 10, 40, 50, 60, 30, 70, 80};
		System.out.println("Running...");
		
		int option = 4;
		
		switch (option) {
		
			case 1: 
				runner.execInsertionSort(arr);
				break;
				
			case 2: 
				runner.execMergeSort(arr);
				break;
			
			case 3: 
				runner.execQuickSort(arr);
				break;
			
			case 4: 
				runner.execNQueens();
				break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
			
		System.out.println("\nFinished...");
	}

}
