#include <iostream>

void swap(int *i_pointer, int *j_pointer)
{
    int temp = *i_pointer;
    *i_pointer = *j_pointer;
    *j_pointer = temp;
}

void selection_sort(int array[], int length)
{
    int index_i, index_j, min_index;
    
    for(index_i = 0; index_i < length-1; index_i++)
    {
        min_index = index_i;
        for (index_j = index_i + 1; index_j < length; index_j++)
            if (array[index_j] < array[min_index])
                min_index = index_j;
            
        swap(&array[min_index], &array[index_i]);
    }
}

void print_array(int array[], int length)
{
    int index;
    for (index = 0; index < length; index++)
        std::cout << array[index] << " ";
    std::cout << std::endl;
}

int main()
{
    int array[] = {78, 80, 40, 20, 30};
    int length = (sizeof(array)/sizeof(int));
    selection_sort(array, length);
    std::cout << "Sorted array: \n";
    print_array(array, length);
    return 0;
}