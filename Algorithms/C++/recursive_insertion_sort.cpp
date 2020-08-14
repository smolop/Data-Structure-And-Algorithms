#include<iostream>
#include<array>

void recursive_insertion_sort(int v[], int size, int n){
    if (n <= 1)
        return;

    recursive_insertion_sort(v, size, n - 1);

    int last = v[n - 1];
    int j = n - 2;

    while(j >= 0 && last < v[j]){
        v[j + 1] = v[j];
        j--;
    }
    v[j + 1] = last;
}

void printer(int v[], int size){
    for (int i = 0; i < size; i++)
        std::cout << v[i] << " ";
        std::cout << std::endl;
}

int main(){
    int array[] = {10, 40, 30, 20, 70, 80, 60};
    int size = sizeof(array)/sizeof(int); 
    recursive_insertion_sort(array, size, size);
    printer(array, size);
    return 0;    
}