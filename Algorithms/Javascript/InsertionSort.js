function InsertionSort(arr){
    for (let i = 1; i < arr.length; i++){
        var key = arr[i]
        var j = i - 1;
        for(;j >= 0 && key < arr[j];)
            arr[j+1] = arr[j--];
        arr[j+1] = key;
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
    InsertionSort(array);
    console.log("Sorted vector: ");
    PrintArray(array);
    console.log("finished...");
}

main();
