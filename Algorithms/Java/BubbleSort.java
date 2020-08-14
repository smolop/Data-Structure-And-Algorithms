
public class BubbleSort {

	static void bubbleSort(int[] array) {
		boolean flag = false;
		while(!flag) {
			flag = true;
			for (int i = 0; i < array.length - 1; i++) 
				if(array[i] > array[i+1]){
					swap(array, i);
					flag = false;
				}
		}
	}
	
	private static void swap(int[] array, int i) {
		int tmp = array[i];
		array[i] = array[i+1];
		array[i+1] = tmp;
	}

	public static void main(String[] args) {
		int array[] = {30, 10, 40, 20, 80, 60, 50, 70};
		bubbleSort(array);
		String sortedArray = java.util.Arrays.toString(array);
		System.out.println(sortedArray);
	}
}
