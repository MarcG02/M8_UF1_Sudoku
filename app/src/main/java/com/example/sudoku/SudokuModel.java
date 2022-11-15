package com.example.sudoku;

import android.util.Log;

public class SudokuModel {
    private int Sudoku[][] = new int[9][9];

    public SudokuModel (){
        for (int i = 0; i < Sudoku.length; i++){
            for (int j = 0; j < Sudoku.length; j++){
                Sudoku[i][j] = 0;
            }
        }
    }

    public int getVal(int i, int j){
        return Sudoku[i][j];
    }

    public boolean setVal(int i, int j, int value){
        boolean correctValue = true;
        //Horizontal validation
        for (int x = 0; x < Sudoku[i].length; x++){
            if (x != j && value == Sudoku[i][x] && Sudoku[i][x] != 0){
                correctValue = false;
            }

        }

        //Vertical validation
        for (int y = 0; y < Sudoku.length; y++){
            if (i != y && value == Sudoku[y][j] && Sudoku[y][j] != 0){
                correctValue = false;
            }
        }

        if (correctValue){
            Sudoku[i][j] = value;
        }
        Log.v("BUENAS", String.valueOf(correctValue));
        return correctValue;
    }

}
