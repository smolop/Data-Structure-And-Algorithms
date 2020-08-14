#include <iostream>

void Swap(int *i_ptr, int *j_ptr)
{
    int tmp = *i_ptr;
    *i_ptr = *j_ptr;
    *j_ptr = tmp;
}

void Heapify(int arr[], int N, int i)
{
    int largest = i;
    int l = (2 * i) + 1;
    int r = (2 * i) + 2;

    if (l < N && arr[largest] < arr[l])
        largest = l;
    if (r < N && arr[largest] < arr[r])
        largest = r;

    if (largest != i)
    {
        Swap(&arr[largest], &arr[i]);
        Heapify(arr, N, largest);
    }
}

void Sort(int arr[], int size)
{
    int N = size;

    for (int last = (int)(N / 2) - 1; last >= 0; last--)
        Heapify(arr, N, last);

    for (int last = N - 1; last > 0; last--)
    {
        Swap(&arr[last], &arr[0]);
        Heapify(arr, last, 0);
    }
}

void PrinterArray(int arr[], int size)
{
    for (int i = 0; i < size; i++)
        std::cout << arr[i] << " ";
    std::cout << std::endl;
}

int main(int argc, char **argv)
{
    int array[] = {10, 40, 30, 20, 70, 80, 60};
    int size = sizeof(array) / sizeof(int);
    Sort(array, size);
    PrinterArray(array, size);
    return 0;
}
