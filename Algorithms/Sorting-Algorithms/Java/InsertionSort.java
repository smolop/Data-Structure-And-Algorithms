public class InsertionSort {

	private static void insertionSort(int[] v) {
		for (int i = 1; i < v.length; i++) {
			int key = v[i];
			int j = i - 1;
			for ( ; j >= 0 && key < v[j]; j--) 
				v[j+1] = v[j];
			v[j+1] = key;
		}
	}
	
	public static void main(String[] args) {
		int array[] = {30, 10, 40, 20, 80, 60, 50, 70};
		insertionSort(array);
		String sortedArray = java.util.Arrays.toString(array);
		System.out.println(sortedArray);
	}
}
