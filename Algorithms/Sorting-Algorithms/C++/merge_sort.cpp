#include <iostream>

void merge(int arr[], int left, int middle, int right)
{
    int l_size = middle - left + 1;
    int r_size = right - middle;
    int L[l_size], R[r_size];
    int i, j, k;

    for (i = 0; i < l_size; i++)
        L[i] = arr[left + i];
    for (j = 0; j < r_size; j++)
        R[j] = arr[middle + 1 + j];

    i = 0; j = 0;
    k = left;

    while (i < l_size && j < r_size)
        arr[k++] = L[i] < R[j] ? L[i++] : R[j++];

    while (i < l_size)
        arr[k++] = L[i++];
    while (j < r_size)
        arr[k++] = R[j++];
}

void merge_sort(int arr[], int left, int right)
{
    if (left < right){
        int middle = left + (right - left) / 2;

        merge_sort(arr, left, (int) middle);
        merge_sort(arr, (int) middle + 1, right);

        merge(arr, left, middle, right);
    }
}

void print_array(int arr[], int size)
{
    for (int i = 0; i < size; i++)
        std::cout << arr[i] << " ";
    std::cout << std::endl;
}

int main(int argc, char **args)
{
    int left, right, size;
    int array[] = {10, 30, 20, 70, 40, 50, 60};
    size = int ((sizeof(array) / sizeof(int)));
    left = 0;
    right = size - 1;
    merge_sort(array, left, right);
    print_array(array, size);
    return 0;
}