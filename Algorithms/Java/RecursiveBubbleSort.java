public class RecursiveBubbleSort {

	public static void recursiveBubbleSort(int v[]) {
		for (int i = 0; i < v.length - 1; i++) 
			if(v[i] > v[i+1]) {
				swap(v, i);
				recursiveBubbleSort(v);
			}
	}
	
	private static void swap(int v[], int i) {
		int tmp = v[i];
		v[i] = v[i+1];
		v[i+1] = tmp;
	}

	public static void main(String[] args) {
		int array[] = {30, 10, 40, 20, 80, 60, 50, 70};
		recursiveBubbleSort(array);
		String sortedArray = java.util.Arrays.toString(array);
		System.out.println(sortedArray);
	}

}
