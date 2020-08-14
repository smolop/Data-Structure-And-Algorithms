#include <iostream>

void SwapPointers(int * i_pointer, int * j_pointer){
    int tmp = *i_pointer;
    *i_pointer = *j_pointer;
    *j_pointer = tmp;
}

void PrintArray(int arr[], int size){
    for (int i = 0; i < size; i++)
        std::cout << (i == 0 ? "[" : "") << arr[i] << (i == size - 1 ? "]\n" : ", ");
    std::cout << std::endl;
}

void BubbleSort(int arr[], int size){
    bool flag = true;
    while (flag){
        flag = true;
        for (int i = 0; i < size - 1; i++)
            if (arr[i] > arr[i+1]){
                SwapPointers(&arr[i], &arr[i+1]);
            flag = false;
            }
    }
}

void InsertionSort(int arr[], int size){
    for (int i = 1; i < size; i++)
    {
        int key = arr[i];
        int j = i;
        while ( --j >= 0 && key < arr[j])
            arr[j + 1] = arr[j];
        arr[j + 1] = key;
    }
}

void SelectionSort(int arr[], int size){
    for (unsigned i = 0; i < size - 1; i++){
        int min_idx = i;
        for (unsigned j = i + 1; j < size; j++)
            if(arr[j] < arr[min_idx])
                min_idx = j;
        SwapPointers(&arr[i], &arr[min_idx]);
    }    
}

void Merge(int arr[], int left, int middle, int right){
    int left_size = middle + 1 - left;
    int right_size = right - middle;

    int L[left_size], R[right_size];

    int i, j, k;

    for (unsigned i = 0; i < left_size; i++)
        L[i] = arr[left + i];
    for (unsigned j = 0; j < right_size; j++)
        R[j] = arr[middle + 1 + j];

    
    i = j = 0;
    k = left;

    while(i < left_size && j < right_size)
        arr[k++] = L[i] < R[j] ? L[i++] : R[j++];

    while (i < left_size)
        arr[k++] = L[i++];
    while (j < right_size)
        arr[k++] = R[j++];
}

void MergeSort(int arr[], int left, int right){
    if(left < right){
        int middle = (int) (left + (right - left) / 2);

        MergeSort(arr, left, middle);
        MergeSort(arr, middle + 1, right);

        Merge(arr, left, middle, right);
    }
}

int Partition(int arr[], int lower_bound, int upper_bound){
    int pivot = arr[upper_bound];
    int lb_idx = lower_bound;

    for (unsigned i = lb_idx; i < upper_bound; i++)
        if(arr[lb_idx] < pivot)
            SwapPointers(&arr[i], &arr[lb_idx++]);
    SwapPointers(&arr[lb_idx], &arr[upper_bound]);

    return lb_idx;
}

void QuickSort(int arr[], int lower_bound, int upper_bound){
    if (lower_bound < upper_bound){
        int pivot_idx = Partition(arr, lower_bound, upper_bound);

        QuickSort(arr, lower_bound, pivot_idx - 1);
        QuickSort(arr, pivot_idx + 1, upper_bound);
    }
}

void ExecuteBubbleubbleSort(int arr[], int size){
    BubbleSort(arr, size);
}

void ExecuteInsertionSort(int arr[], int size){
    InsertionSort(arr, size);
}

void ExecuteSelectionSort(int arr[], int size){
    SelectionSort(arr, size);
}

void ExecuteMergeSort(int arr[], int size){
    int right = size - 1;
    int left = 0;
    MergeSort(arr, left, right);
}

void ExecuteQuickSort(int arr[], int size){
    int lower_bound = 0;
    int upper_bound = size - 1;
    QuickSort(arr, lower_bound, upper_bound);
}

void ExecuteAlgorithms(){
    int array[] = {10, 40, 30, 20, 70, 80, 60, 50};
    int size = sizeof(array) / sizeof(int);
    //ExecuteBubbleubbleSort(array, size);
    //ExecuteInsertionSort(array, size);
    //ExecuteSelectionSort(array, size);
    //ExecuteMergeSort(array, size);
    ExecuteQuickSort(array, size);
    PrintArray(array, size);
}

int main(int argc, char ** argv){
    ExecuteAlgorithms();
    return 0;
}