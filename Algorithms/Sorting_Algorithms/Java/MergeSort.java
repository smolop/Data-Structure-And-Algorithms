public class MergeSort {

	private static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			
			int middle = (right + left ) / 2;
			
			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);
			
			merge(array, left, middle, right);
		}
	}

	private static void merge(int[] array, int left, int middle, int right) {
		int lSize = middle - left + 1;
		int rSize = right - middle;
		
		int L[] = new int[lSize];
		int R[] = new int[rSize];
		
		for (int i = 0; i < lSize; i++)
			L[i] = array[left + i];
		for (int j = 0; j < rSize; j++)
			R[j] = array[middle + 1 + j];
		
		int	i = 0, j = 0;
		int k = left;
		
		while (i < lSize && j < rSize) 
			array[k++] = L[i] < R[j] ? L[i++] : R[j++];

		while(i < lSize)
			array[k++] = L[i++];
		
		while(j < rSize)
			array[k++] = R[j++];
	}
	
	public static void main(String [] args) {
		int array[] = {30, 10, 40, 20, 80, 60, 50, 70};
		int left, right;
		left = 0;
		right = array.length - 1;
		mergeSort(array, left, right);
		String sortedArray = java.util.Arrays.toString(array);
		System.out.println(sortedArray);
	}
}
