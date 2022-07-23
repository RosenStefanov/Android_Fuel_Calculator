package com.example.fuelcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TripCalculatorActivity extends AppCompatActivity {
    private Button lper100;
    private Button kmperl;
    private Button ukmpg;
    private Button usmpg;
    private Button back;
    private TextView tripinfo;
    private TextView tripConsText;
    private EditText tripConsInput;
    private TextView tripDistText;
    private EditText tripDistInput;
    private TextView fuelPriceText;
    private EditText fuelPriceInput;
    private Button tripCost;
    private TextView outputText;
    private TextView outputNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_calculator);
        lper100 = (Button) findViewById(R.id.tripLper100);
        kmperl = (Button) findViewById(R.id.tripkmperl);
        ukmpg = (Button) findViewById(R.id.tripUkmpg);
        usmpg = (Button) findViewById(R.id.tripUsmpg);
        back = (Button) findViewById(R.id.tripback);
        tripinfo = (TextView) findViewById(R.id.tripInfo);
        tripConsText = (TextView) findViewById(R.id.tripConsText);
        tripConsInput = (EditText) findViewById(R.id.tripConsInput);
        tripDistText = (TextView) findViewById(R.id.tripDistanceText);
        tripDistInput = (EditText) findViewById(R.id.tripDistInput);
        fuelPriceText = (TextView) findViewById(R.id.costtext);
        fuelPriceInput = (EditText) findViewById(R.id.tripCostInput);
        tripCost = (Button) findViewById(R.id.tripCost);
        outputText = (TextView) findViewById(R.id.tripCostText);
        outputNumber = (TextView) findViewById(R.id.tripCostOutput);

        lper100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lper100Click();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backClick();
            }
        });

        kmperl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kmperlClick();
            }
        });
        ukmpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ukmpgClick();
            }
        });

        usmpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usmpgClick();
            }
        });
    }

    //Hides the different units buttons and shows the cost calculator
    public void showCostCalculator() {
        tripinfo.setVisibility(View.GONE);
        lper100.setVisibility(View.GONE);
        kmperl.setVisibility(View.GONE);
        ukmpg.setVisibility(View.GONE);
        usmpg.setVisibility(View.GONE);
        back.setVisibility(View.VISIBLE);
        tripConsText.setVisibility(View.VISIBLE);
        tripConsInput.setVisibility(View.VISIBLE);
        tripDistText.setVisibility(View.VISIBLE);
        tripDistInput.setVisibility(View.VISIBLE);
        fuelPriceText.setVisibility(View.VISIBLE);
        fuelPriceInput.setVisibility(View.VISIBLE);
        tripCost.setVisibility(View.VISIBLE);
        outputText.setVisibility(View.VISIBLE);
        outputNumber.setVisibility(View.VISIBLE);
    }

    //Shows the cost calculator using L/100 as consumption unit
    public void lper100Click() {
        tripConsText.setText("Enter the expected L/100 consumption");
        tripDistText.setText("Enter the distance of the trip in Km");
        fuelPriceText.setText("Cost of one Liter of fuel");
        showCostCalculator();
        tripCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tripCostClick(0);
            }
        });
    }

    //Shows the cost calculator using UK MPG as consumption unit
    public void ukmpgClick() {
        tripConsText.setText("Enter the expected UK MPG consumption");
        tripDistText.setText("Enter the distance of the trip in Miles");
        fuelPriceText.setText("Cost of one Gallon of fuel");
        showCostCalculator();
        tripCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tripCostClick(1);
            }
        });
    }

    //Shows the cost calculator using Km/L as consumption unit
    public void kmperlClick() {

        tripConsText.setText("Enter the expected Km/L consumption");
        tripDistText.setText("Enter the distance of the trip in Km");
        fuelPriceText.setText("Cost of one Liter of fuel");
        showCostCalculator();
        tripCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tripCostClick(1);
            }
        });
    }

    //Shows the cost calculator using US MPG as consumption unit
    public void usmpgClick() {
        tripConsText.setText("Enter the expected US MPG consumption");
        tripDistText.setText("Enter the distance of the trip in Miles");
        fuelPriceText.setText("Cost of one Gallon of fuel");
        showCostCalculator();
        tripCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tripCostClick(1);
            }
        });
    }

    //Hides the cost calculator and shows the unit options
    public void backClick() {
        tripConsText.setText("");
        tripDistText.setText("");
        fuelPriceText.setText("");
        outputNumber.setText("");
        tripConsInput.setText("");
        tripDistInput.setText("");
        fuelPriceInput.setText("");
        tripinfo.setVisibility(View.VISIBLE);
        lper100.setVisibility(View.VISIBLE);
        kmperl.setVisibility(View.VISIBLE);
        ukmpg.setVisibility(View.VISIBLE);
        usmpg.setVisibility(View.VISIBLE);
        back.setVisibility(View.GONE);
        tripConsText.setVisibility(View.GONE);
        tripConsInput.setVisibility(View.GONE);
        tripDistText.setVisibility(View.GONE);
        tripDistInput.setVisibility(View.GONE);
        fuelPriceText.setVisibility(View.GONE);
        fuelPriceInput.setVisibility(View.GONE);
        tripCost.setVisibility(View.GONE);
        outputText.setVisibility(View.GONE);
        outputNumber.setVisibility(View.GONE);
    }

    //Calculates the cost of the trip
    public void tripCostClick(int numb) {
        String fuel = tripConsInput.getText().toString();
        String distance = tripDistInput.getText().toString();
        String cost = fuelPriceInput.getText().toString();
        double fueld = 0;
        double distanced = 0;
        double costd = 0;
        double output;
        if (!fuel.isEmpty()) {
            fueld = Double.parseDouble(fuel);
        }
        if (!distance.isEmpty()) {
            distanced = Double.parseDouble(distance);
        }
        if (!cost.isEmpty()) {
            costd = Double.parseDouble(cost);
        }
        if (costd != 0 && distanced != 0 && fueld != 0) {
            switch (numb) {
                case 0:
                    output = distanced / 100 * fueld * costd;
                    output = Math.round(output * 100) / 100D;
                    outputNumber.setText(String.valueOf(output));
                    break;
                case 1:
                    output = distanced / fueld * costd;
                    output = Math.round(output * 100) / 100D;
                    outputNumber.setText(String.valueOf(output));
                    break;
            }
        }
    }
}