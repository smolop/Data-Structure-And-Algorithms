package sort;

public class QuickSort {
	private int[] arr;
	
	public QuickSort(int[] arr) {
		this.arr = arr;
	}
	
	public void solve() {
		System.out.println("Quick Sort:");
		quickSort(0, arr.length - 1);
	}
	
	void quickSort(int lowereBound, int upperBound) {
		if (lowereBound < upperBound) {
			int pivotIndex = partition(lowereBound, upperBound);
			
			quickSort(lowereBound, pivotIndex - 1);
			quickSort(pivotIndex + 1, upperBound);
		}
	}

	private int partition(int lowerBound, int upperBound) {
		int pivot = arr[upperBound];
		int lowerBoundIndex = lowerBound;
		
		for (int index = lowerBoundIndex; index < upperBound; index++)
			if (arr[index] < pivot)
				swap(index, lowerBoundIndex++);
		swap(lowerBoundIndex, upperBound);
		return lowerBoundIndex;
	}

	private void swap(int indexA, int indexB) {
		int tmp = arr[indexA];
		arr[indexA] = arr[indexB];
		arr[indexB] = tmp;
	}
	
}
