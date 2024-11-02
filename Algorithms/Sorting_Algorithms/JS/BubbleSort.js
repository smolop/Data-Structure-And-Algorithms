
function Swap(arr, i, j){
    var tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}

function BubbleSort(arr){
    var flag = true;
    while(flag){
        flag = false;
        for (let index = 0; index < arr.length - 1; index++)
            if(arr[index] > arr[index + 1]){
                Swap(arr, index, index+1);
                flag = true;
            }
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
    console.log("Bubble Sort");
    array = [30, 40, 10, 60, 50, 80, 70, 20];
    console.log("Original vector: ");
    PrintArray(array);
    BubbleSort(array);
    console.log("Sorted vector: ");
    PrintArray(array);
    console.log("finished...");
}

main();
