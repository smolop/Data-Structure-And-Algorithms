package sort;

public class MergeSort {
	
	int[] arr;
	
	public MergeSort(int[] arr) {
		this.arr = arr;
	}
	
	public void solve() {
		System.out.println("Merge Sort:");
		mergeSort(0, this.arr.length - 1);
	}
	
	void mergeSort( int left, int right) {
		if (left < right) {
			int middle = (right + left) / 2;
			
			mergeSort(left, middle);
			mergeSort(middle + 1, right);
			
			merge(left, middle, right);
		}
	}
	
	void merge(int left, int middle, int right) {
		int lSize = middle +  1 - left;
		int rSize = right - middle;
		
		int[] L = new int[lSize];
		int[] R = new int[rSize];
		
		for (int index = 0; index < lSize; index++)
			L[index] = arr[left + index];
		for (int index = 0; index < rSize; index++)
			R[index] = arr[middle + 1 + index];
		
		int lIndex, rIndex, arrIndex;
		lIndex = rIndex = 0;
		arrIndex = left;
		
		while (lIndex < lSize && rIndex < rSize)
			arr[arrIndex++] = L[lIndex] < R[rIndex] ? L[lIndex++] : R[rIndex++];
			
		while (lIndex < lSize)
			arr[arrIndex++] = L[lIndex++];
		while (rIndex < rSize)
			arr[arrIndex++] = R[rIndex++];
	}
	

}
