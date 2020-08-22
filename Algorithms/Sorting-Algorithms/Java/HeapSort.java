
public class HeapSort {

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	private static void heapify(int[] arr, int last, int i) {
		int largest = i;
		int l = (2 * i) + 1;
		int r = (2 * i) + 2;
		
		if (l < last && arr[largest] < arr[l] ) 
			largest = l;
		if (r < last && arr[largest] < arr[r])
			largest = r;
		
		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, last, largest);
		}
	}
	
	private static void heapSort(int[] arr) {
		
		int last = arr.length;
		
		for (int i = (int) (last/2) - 1; i >= 0; i--)
			heapify(arr, last, i);
		
		for (int i = last - 1; i > 0; i--) {
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
		
	}

	public static void main(String[] args) {
		int array[] = {30, 10, 40, 20, 80, 60, 50, 70};
		heapSort(array);
		String sortedArray = java.util.Arrays.toString(array);
		System.out.println(sortedArray);
	}
}
