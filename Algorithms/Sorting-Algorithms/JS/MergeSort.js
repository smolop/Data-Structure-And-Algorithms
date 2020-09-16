function Merge(arr, left, middle, right){
    var left_size = middle + 1 - left;
    var right_size = right - left;

    L = new Array();
    R = new Array();

    for (let i = 0; i < left_size; i++)
        L[i] = arr[left + i];
    for (let j = 0; j < right_size; j++)
        R[i] = arr[middle + j];

    i = j = 0;
    k = left;

    while (i < left_size && j < right_size)
        arr[k++] = L[i] < R[j] ? L[i++] : R[j++];
    
    while (i < left_size)
        arr[k++] = L[i++];

    while (j < right_size)
        arr[k++] = R[j++];
}

function MergeSort(arr, left, righ){
    if (left < right){
        var middle = Math.round((righ - left) / 2);

        MergeSort(arr, left, righ);
        MergeSort(arr, left, righ);

        Merge(arr, left, middle, righ);
    }
}

function PrintArray(arr){
    sb = ""
    arr.forEach(element => {
        sb += ` ${element}`;
    });
     console.log(sb);
}

function main(){
    console.log("Merge Sort");
    array = [30, 40, 10, 60, 50, 80, 70, 20];
    console.log("Original vector: ");
    PrintArray(array);
    MergeSort(array);
    console.log("Sorted vector: ");
    PrintArray(array);
    console.log("finished...");
}

main();
