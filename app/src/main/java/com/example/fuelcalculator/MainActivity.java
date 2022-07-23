package com.example.fuelcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button calculatorButton;
    private Button converterButton;
    private Button tripButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorButton = (Button) findViewById(R.id.consumption);
        converterButton = (Button) findViewById(R.id.coversion);
        tripButton = (Button) findViewById(R.id.trip);
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConsumption();
            }
        });
        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConverter();
            }
        });
        tripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTrip();
            }
        });
    }

    //Open Consumption calculator activity
    public void openConsumption() {
        Intent intent = new Intent(this, ConsumptionCalculator.class);
        startActivity(intent);
    }

    //Open consumption converter activity
    public void openConverter() {
        Intent intent = new Intent(this, ConverterActivity.class);
        startActivity(intent);
    }

    //Open trip cost calculator activity
    public void openTrip() {
        Intent intent = new Intent(this, TripCalculatorActivity.class);
        startActivity(intent);
    }
}