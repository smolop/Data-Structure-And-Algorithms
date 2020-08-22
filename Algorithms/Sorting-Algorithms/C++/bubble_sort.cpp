#include <iostream>

void swap(int *i_pointer, int *j_pointer)
{
    int temp = *i_pointer;
    *i_pointer = *j_pointer;
    *j_pointer = temp;
}

void print_array(int array[], int length)
{
    int index;
    for (index = 0; index < length; index++)
        std::cout << array[index] << " ";
    std::cout << std::endl;
}

void bubble_sort(int array[], int length)
{
    bool flag = false;
    while(!flag){
        flag = true;
        for (int i = 0; i < length - 1; i++)
            if(array[i] > array[i+1])
            {
                swap(&array[i], &array[i+1]);
                //std::printf("a=%d b=%d", array[i], array[i+1]);
                flag = false;
            }
    }
}

int main()
{
    int array[] = {10, 40, 30, 20, 70, 80, 60};
    int length = sizeof(array) / sizeof(int);
    bubble_sort(array, length);
    std::cout << "Sorted array: \n";
    print_array(array, length);
    return 0;
}