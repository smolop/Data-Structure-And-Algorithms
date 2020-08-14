#include <iostream>

void swap(int * current_pointer, int * next_pointer)
{
    int tmp = *current_pointer;
    *current_pointer = *next_pointer;
    *next_pointer = tmp;
}

void recursive_bubble_sort(int array[], int size)
{
    for (int i = 0; i < size - 1; i++)
    {
        if(array[i] > array[i+1])
        {
            swap(&array[i], &array[i+1]);
            return recursive_bubble_sort(array, size);
        }
    }
}

void printer(int array[], int size)
{
    for(int i = 0; i < size; i++)
        std:printf("%d ", array[i]);
}

int main()
{
    int array[] = {10, 40, 30, 20, 70, 80, 60};
    int size = sizeof(array)/sizeof(int);
    recursive_bubble_sort(array, size);
    printer(array, size);
    return 0;
}