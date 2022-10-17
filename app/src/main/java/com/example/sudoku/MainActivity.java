package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CharSequence[] nombres = {"1","2","3","4","5","6","7","8","9"};


        TableLayout tabla = findViewById(R.id.TableId);

        TableRow row = new TableRow(this);

        for (int i = 0; i < 9; i++){
            Spinner spinner = new Spinner(this);
            spinner.setBackground(null);
            ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                    android.R.layout.simple_spinner_item, nombres);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setPadding(5, 5, 5, 5);
            spinner.setAdapter(adapter);
            row.addView(spinner);
        }

        tabla.addView(row);
    }
}