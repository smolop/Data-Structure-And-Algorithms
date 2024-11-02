
public class RecursiveInsertionSort {

	static void recursiveInsertionSort(int[] array, int n) {
		if (n <= 1)
			return;
		
		recursiveInsertionSort(array, n-1);
		
		int last = array[n - 1];
		int j = n - 2;
		
		while(j >= 0 && last < array[j]) 
			array[j+1] = array[j--];
		array[j+1] = last;
	}
	
	public static void main(String[] args) {
		int array[] = {30, 10, 40, 20, 80, 60, 50, 70};
		int length = array.length;
		recursiveInsertionSort(array, length);
		String sortedArray = java.util.Arrays.toString(array);
		System.out.println(sortedArray);
	}
}
