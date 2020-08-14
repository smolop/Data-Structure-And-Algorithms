public class SelectionSort {

	static void selectionSort(int v[]) {
		int minPos;
		for (int i = 0; i < v.length; i++) {
			minPos = i;
			for (int j = i+1; j < v.length; j++) 
				if(v[minPos] > v[j])
					minPos = j;
			swap(v, minPos, i);
		}
	}
	
	private static void swap(int[] v, int minPos, int i) {
		int tmp = v[minPos];
		v[minPos] = v[i];
		v[i] = tmp;
	}

	public static void main(String[] args) {
		int array[] = {30, 10, 40, 20, 80, 60, 50, 70};
		selectionSort(array);
		String sortedArray = java.util.Arrays.toString(array);
		System.out.println(sortedArray);
	}
}
