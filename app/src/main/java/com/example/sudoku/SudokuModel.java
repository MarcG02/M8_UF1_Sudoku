package com.example.sudoku;

public class SudokuModel {
    private int Sudoku[][] = new int[9][9];

    private void setInitValue(){
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
        //Horizontal checkout
        for (int x = 0; x < Sudoku[i].length; x++){
            if (x != j && value != Sudoku[i][x] && Sudoku[i][x] == 0){
                correctValue = true;
                return correctValue;
            }
            else{
                correctValue = false;
                return correctValue;
            }
        }

        //Vertical checkout
        for (int y = 0; y < Sudoku[j].length; y++){
            if (j != i && value != Sudoku[j][y] && Sudoku[j][y] == 0){
                correctValue = true;
                return correctValue;
            }
            else{
                correctValue = false;
                return correctValue;
            }
        }
        if (correctValue){
            Sudoku[i][j] = value;
        }
        return correctValue;
    }

}
