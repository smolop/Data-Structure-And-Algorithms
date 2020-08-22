#include <iostream>

void insertion_sort(int array[], int length){
	for(int i = 0; i < length; i++){
		int key = array[i];
		int j = i-1;
		while (j > 0 && key < array[j]){
			array[j+1] = array[j];
			j--;
		}
		array[j+1] = key; 
	}
}

void print_array(int array[], int length)
{
    int index;
    for (index = 0; index < length; index++)
        std::cout << array[index] << " ";
    std::cout << std::endl;
}

int main(){
	int array[] = {10, 30, 20, 70, 40, 50, 60};
	int length = (sizeof(array)/sizeof(int));		
	insertion_sort(array, length);
	print_array(array, length);
}