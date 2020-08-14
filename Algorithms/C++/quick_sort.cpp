#include <iostream>

void swap(int * i_p, int * j_p){
    int tmp = *i_p;
    *i_p = *j_p;
    *j_p = tmp;
}

int partition(int arr[], int lower_bound, int upper_bound){
    int pivot = arr[upper_bound];
    int lb_idx = lower_bound;

    for (int j = lb_idx; j < upper_bound; j++)
        if(arr[lb_idx] < pivot)
            swap(&arr[lb_idx++], &arr[j]);
    
    swap(&arr[lb_idx], &arr[upper_bound]);
    return lb_idx;
}

void quick_sort(int arr[], int lower_bound, int upper_bound){
    if (lower_bound < upper_bound){
        int pivot_idx = partition(arr, lower_bound, upper_bound);

        quick_sort(arr, lower_bound, pivot_idx - 1);
        quick_sort(arr, pivot_idx + 1, upper_bound);
    }
}

void print_array(int arr[], int size){
    for (int i = 0; i < size; i++)
        std::cout << arr[i] << " ";
        std::cout << std::endl;
}

int main(int argvc, char ** args){
    int array[] = {10, 40, 30, 20, 70, 80, 60};
    int size = sizeof(array) / sizeof(int);
    int lower_bound = 0;
    int upper_bound = size - 1;
    quick_sort(array, lower_bound, upper_bound);
    print_array(array, size);
    return 0;
}