package com.example.currencyconvertercad_usd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText CAD, USD;
    private Button regBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CAD = findViewById(R.id.etCAD);
        USD = findViewById(R.id.etUSD);
        regBtn = findViewById(R.id.calculate_btn);

        regBtn.setOnClickListener(view -> {
            CAD.clearFocus();
            USD.clearFocus();
            if (CAD.getText().toString().isEmpty() && USD.getText().toString().isEmpty()){
                Toast.makeText(this,
                        "Please enter a value",
                        Toast.LENGTH_LONG).show();
            }
            else if (!CAD.getText().toString().isEmpty() && !USD.getText().toString().isEmpty()){
                Toast.makeText(this,
                        "Please enter value for either CAD or USD",
                        Toast.LENGTH_LONG).show();
            }
            else if (!CAD.getText().toString().isEmpty()) {
                convertCadToUsd(CAD);
            }
            else {
                if (USD.getText().toString().isEmpty()) {
                    return;
                }
                convertUsdToCad(USD);
            }

        });
    }

    @SuppressLint("DefaultLocale")
    private void convertCadToUsd(EditText CAD) {
        double cad = Double.parseDouble(CAD.getText().toString());
        double usd = cad*1.36;
        USD.setText(String.format("%.2f",usd));
        Toast.makeText(this, String.format("%s Canadian Dollar equals %f", CAD.getText(), usd), Toast.LENGTH_LONG).show();
    }

    @SuppressLint("DefaultLocale")
    private void convertUsdToCad(EditText USD) {
        double usd = Double.parseDouble(USD.getText().toString());
        double cad = usd*0.74;
        CAD.setText(String.format("%.2f",cad));
       Toast.makeText(this, String.format("%s Canadian Dollar equals %f", USD.getText(), usd), Toast.LENGTH_LONG).show();

    }
}