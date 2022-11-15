package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static Spinner listSpinner[][] = new Spinner[9][9];
    private static SudokuModel sm = new SudokuModel();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create option array
        CharSequence[] nombres = {"0","1","2","3","4","5","6","7","8","9"};

        TableLayout tabla = findViewById(R.id.TableId);

        //create rows
        for (int filas = 0; filas < 9; filas++){
            TableRow row = new TableRow(this);
            //create cols
            for (int cols = 0; cols < 9; cols++){
                //Spinner creation
                Spinner spinner = new Spinner(this);
                spinner.setBackground(null);
                spinner.setPadding(5, 5, 5, 5);

                //seting rows and cols
                spinner.setTag(R.id.fila,filas);
                spinner.setTag(R.id.col,cols);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        int row = (int) adapterView.getTag(R.id.fila);
                        int col = (int) adapterView.getTag(R.id.col);

                        //if user try to set one of the spinner option and hortitzontaly or verticaly don't pass the validation the view send a msg err
                        if (!sm.setVal(row, col, adapterView.getSelectedItemPosition())){
                            Toast.makeText(MainActivity.this, "ERROR, You can't set this number here", Toast.LENGTH_SHORT).show();
                        }

                        //if option selected pass the validation the view set the option
                        adapterView.setSelection(sm.getVal(row, col));

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }

                });


                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, nombres);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                //adding adapter to spinner
                spinner.setAdapter(adapter);

                //adding spinner to row
                row.addView(spinner);
                listSpinner[filas][cols] = spinner;
            }
            //adding rows to the table
            tabla.addView(row);
        }
        //Starts the game
        creaPartida();

    }

    //Method to create a new game
    public void creaPartida(){
        //Number of random numbers are going to be generated in the view
        int totalNumbers = 20;

        //controls the random numbers
        while (totalNumbers >= 0){
            int randomNumb = (int) Math.floor(Math.random()*(9-1+1)+1);
            int randomRow  = (int) Math.floor(Math.random()*(8));
            int randomCol = (int) Math.floor(Math.random()*(8));

            if(sm.setVal(randomRow, randomCol, randomNumb)){
                totalNumbers--;
            }

        }
        //Update the view
        updateSudoku();

    }

    //Method to update View
    public void updateSudoku(){
        for (int i = 0; i < listSpinner.length; i++){
            for (int j = 0; j < listSpinner[i].length; j++){

                listSpinner[i][j].setSelection(sm.getVal(i, j));

            }
        }
    }


}