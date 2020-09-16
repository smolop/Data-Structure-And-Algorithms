
class NQueens {

    constructor(matrix){
        this.matrix = matrix;
        this.N = matrix.length;
    }

    solve() {
        console.log("%sNQueens:", this.N);
        this.nQueensSolver(0);
    }

    nQueensSolver(col){
        if (col >= this.N)
            return true;
        for (let r = 0; r < this.N; r++)
            if (this.isSafe(r, col)){
                this.putQueen(r, col);
                if (this.nQueensSolver(col + 1)){
                    console.log(`Queen on: [${r}][${col}]`);
                    return true;
                }
                    
                this.removeQueen(r, col);
            }
        return false;
    }

    isSafe(row, col){
        for (let c = 0; c < this.N; c++)
            if (this.isThereAQueen(row, c))
                return false;
        for (let r = row, c = col; r >= 0 && c >= 0; r--, c--)
            if (this.isThereAQueen(r, c))
                return false;
        for (let r = row, c = col; r < this.N && c >= 0; r++, c--)
            if (this.isThereAQueen(r, c))
                return false;
        return true;
    }

    isThereAQueen(row, col){
        return this.matrix[row][col] === 1;
    }

    putQueen(row, col){
        this.matrix[row][col] = 1;
    }

    removeQueen(row, col){
        this.matrix[row][col] = 0;
    }

    printMtx(){
        var stringBuilder = [];
        for (let row = 0; row < this.N; row++) 
           for (let col = 0; col < this.N; col++) 
               stringBuilder.push(this.matrix[row][col] + (col === this.N - 1 ? "\n" : " "));
        console.log(stringBuilder.join(""));
    }

}

function main(){
    var N = 8;
    var matrix = new Array(N).fill(null).map(() => Array(N).fill(0));
    nq = new NQueens(matrix);
    nq.solve();
    nq.printMtx();
}

main();