
function Swap(arr, i, j){
    tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}

function Partition (arr, lower_bound, upper_bound)
{
    pivot = arr[upper_bound];
    lb_idx = lower_bound;

    for (let i = lower_bound; i < upper_bound; i++)
        if (pivot > arr[i])
            Swap(arr, lb_idx++, i)
    Swap(arr, lb_idx, upper_bound);
    return lb_idx;
}

function QuickSort (arr, lower_bound, upper_bound)
{
    if (lower_bound < upper_bound)
    {
        pivot_idx = Partition(arr, lower_bound, upper_bound);
        console.log(`Lower bound: ${lower_bound}`);
        console.log(`Upper bound: ${upper_bound}`);
        console.log(`Pivot_IDX: ${pivot_idx}`);
        console.log("LEFT");
        QuickSort(arr, lower_bound, pivot_idx - 1);
        console.log("RIGHT");
        QuickSort(arr, pivot_idx + 1, upper_bound);
    }
}

function PrintArray(arr){
    sb = "";
    arr.forEach(element => {
        sb += ` ${element}`; 
    });
    console.log(sb);
}

function main ()
{
    console.log("Quick Sort");
    array = [30, 40, 10, 60, 50, 80, 70, 20];
    console.log("Original vector:");
    PrintArray(array);
    QuickSort(array, 0, array.length - 1);
    console.log("Sorted vector:");
    PrintArray(array);
    console.log("Finished...");
}

main();