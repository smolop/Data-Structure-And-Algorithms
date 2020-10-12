
public class QuickSort {

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	private static int partition(int[] arr, int lowerBound, int upperBound) {
		int pivot = arr[upperBound];
		int lb_idx = lowerBound;
		
		for (int j = lb_idx; j < upperBound; j++) 
			if(arr[j] < pivot)
				swap(arr, lb_idx++, j);
		
		swap(arr, lb_idx, upperBound);
		
		return lb_idx;
	}

	private static void quickSort(int[] arr, int lowerBound, int upperBound) {
		
		if(lowerBound < upperBound) {
			int pivot_index = partition(arr, lowerBound, upperBound);
			
			quickSort(arr, lowerBound, pivot_index - 1);
			quickSort(arr, pivot_index + 1, upperBound);
		}
		
	}

	public static void main(String[] args) {
		int array[] = {30, 10, 40, 20, 80, 60, 50, 70};
		int lowerBound = 0;
		int upperBound = array.length - 1;
		quickSort(array, lowerBound, upperBound);
		String sortedArray = java.util.Arrays.toString(array);
		System.out.println(sortedArray);
	}
	
}
