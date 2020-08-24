#include <stdio.h>
#include <stdbool.h>
#include <iostream>

#define N 16


bool IsSafe(int m[N][N], int row, int col){

    for (int c = 0; c < N; c++)
        if(m[row][c])
            return false;

    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if(m[i][j])
            return false;

    for (int i = row, j = col; i < N && j >= 0; i++, j--)
        if(m[i][j])
            return false;

    return true;
}


bool Solver(int m[N][N], int col){

    if(col >= N)
        return true;

    for (int i = 0; i < N; i++){
            if(IsSafe(m, i, col)){
                m[i][col] = 1;

                if(Solver(m, col + 1))
                    return true;

                m[i][col] = 0;
            }
    }
    return false;
}


void PrintMatrix(int m[N][N]){
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            std::cout << m[i][j] << ((j == N - 1) ? "\n" : ",");
        std::cout << std::endl;
}


void SolveNQueens(){
    // int m4[N][N] = { { 0, 0, 0, 0 }, 
    //                     { 0, 0, 0, 0 }, 
    //                     { 0, 0, 0, 0 }, 
    //                     { 0, 0, 0, 0 } }; 

    // int m8[N][N] = {{ 0, 0, 0, 0, 0, 0, 0, 0},
    //             { 0, 0, 0, 0, 0, 0, 0, 0},
    //             { 0, 0, 0, 0, 0, 0, 0, 0},
    //             { 0, 0, 0, 0, 0, 0, 0, 0},
    //             { 0, 0, 0, 0, 0, 0, 0, 0},
    //             { 0, 0, 0, 0, 0, 0, 0, 0},
    //             { 0, 0, 0, 0, 0, 0, 0, 0},
    //             { 0, 0, 0, 0, 0, 0, 0, 0}};
    
    int m16[N][N] = {{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}; 
                        
    if(Solver(m16, 0))
        PrintMatrix(m16);
    else
        printf("Sorry! Solution not found.");
}


int main(int argc, char ** args){
    SolveNQueens();
    return 0;
}