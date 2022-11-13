package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {
    private static Spinner listSpinner[][] = new Spinner[9][9];
    private static SudokuModel sm = new SudokuModel();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CharSequence[] nombres = {"0","1","2","3","4","5","6","7","8","9"};

        int cont = 0;

        TableLayout tabla = findViewById(R.id.TableId);

        //creem les files
        for (int filas = 0; filas < 9; filas++){
            TableRow row = new TableRow(this);
            //creem les columnes
            for (int cols = 0; cols < 9; cols++){
                Spinner spinner = new Spinner(this);
                spinner.setBackground(null);
                spinner.setPadding(5, 5, 5, 5);
                spinner.setTag(R.id.fila,filas);
                spinner.setTag(R.id.col,cols);

                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, nombres);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner.setAdapter(adapter);
                row.addView(spinner);
                listSpinner[filas][cols] = spinner;
            }
            tabla.addView(row);
        }
        creaPartida();

    }

    public void creaPartida(){
        int totalNumbers = 20;

        while (totalNumbers > 0){
            int randomNumb = (int) Math.floor(Math.random()*(9-1+1)+1);
            int randomRow  = (int) Math.floor(Math.random()*(8));
            int randomCol = (int) Math.floor(Math.random()*(8));

            listSpinner[randomRow][randomCol].setSelection(randomNumb);

            totalNumbers--;

        }

    }
}