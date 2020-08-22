
function Swap(arr, i, j){
    var tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}

function SelectionSort(arr){
    for(let i = 0; i < arr.length; i++){
        min_idx = i;
        for(var j = min_idx; j < arr.length; j++)
            if(arr[min_idx] > arr[j])
                min_idx = j;
        Swap(arr, min_idx, i);
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
    console.log("Insertion Sort");
    array = [30, 40, 10, 60, 50, 80, 70, 20];
    console.log("Original vector: ");
    PrintArray(array);
    SelectionSort(array);
    console.log("Sorted vector: ");
    PrintArray(array);
    console.log("finished...");
}

main();
