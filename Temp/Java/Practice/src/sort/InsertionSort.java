package sort;

public class InsertionSort {
	private int[] arr;
	public InsertionSort(int[] arr) {
		this.arr = arr;
	}
	
	public void solve() {
		insertionSort();
	}
	
	private void insertionSort() {
		System.out.println("Insertion Sort:");
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && key < arr[j])
				arr[j+1] = arr[j--];
			arr[j+1] = key;
		}
	}

	int[] getArr() {
		return this.arr;
	}
}
