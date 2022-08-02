package com.example.fuelcalculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ConsumptionCalculator extends AppCompatActivity {
    private Button lper100;
    private TextView textView2;
    private Button kmperl;
    private Button ukmpg;
    private Button usmpg;
    private Button back;
    private TextView constext;
    private EditText fuelinput;
    private TextView distance;
    private EditText distanceinput;
    private Button calculate;
    private TextView consoutput;
    private TextView convtype;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumption_calculator);
        lper100 = (Button) findViewById(R.id.lper100);
        textView2 = (TextView) findViewById(R.id.textView2);
        kmperl = (Button) findViewById(R.id.kmperl);
        ukmpg = (Button) findViewById(R.id.ukmpg);
        usmpg = (Button) findViewById(R.id.usmpg);
        back = (Button) findViewById(R.id.consback);
        constext = (TextView) findViewById(R.id.constext);
        fuelinput = findViewById(R.id.fuelinput);
        distance = (TextView) findViewById(R.id.distance);
        distanceinput = findViewById(R.id.distanceinput);
        calculate = (Button) findViewById(R.id.calculatebutton);
        consoutput = (TextView) findViewById(R.id.consoutput);
        convtype = (TextView) findViewById(R.id.convtype);
        layout = (ConstraintLayout) findViewById(R.id.layout);
        lper100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lper100Click();
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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backClick();
            }
        });
    }

    //Hides the different units buttons and shows the calculator
    public void showCalculator() {
        textView2.setVisibility(View.GONE);
        lper100.setVisibility(View.GONE);
        kmperl.setVisibility(View.GONE);
        ukmpg.setVisibility(View.GONE);
        usmpg.setVisibility(View.GONE);
        back.setVisibility(View.VISIBLE);
        constext.setVisibility(View.VISIBLE);
        fuelinput.setVisibility(View.VISIBLE);
        distance.setVisibility(View.VISIBLE);
        distanceinput.setVisibility(View.VISIBLE);
        calculate.setVisibility(View.VISIBLE);
        consoutput.setVisibility(View.VISIBLE);
        convtype.setVisibility(View.VISIBLE);
    }

    //Starts the L/100 calculator on the button click
    public void lper100Click() {
        constext.setText("Liters (L) spent fuel");
        distance.setText("Kilometers (Km) driven");
        convtype.setText("L/100");
        showCalculator();
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateClick(0);
            }
        });
    }

    //Starts the uk mpg calculator on the button click
    public void ukmpgClick() {
        constext.setText("UK Gallons spent fuel");
        distance.setText("Miles driven");
        convtype.setText("UK MPG");
        showCalculator();
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateClick(2);
            }
        });
    }

    //Starts the us mpg calculator on the button click
    public void usmpgClick() {
        constext.setText("US Gallons spent fuel");
        distance.setText("Miles driven");
        convtype.setText("US MPG");
        showCalculator();
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateClick(3);
            }
        });
    }

    //Starts the Km/L calculator on the button click
    public void kmperlClick() {
        constext.setText("Liters (L) spent fuel");
        distance.setText("Kilometers (Km) driven");
        convtype.setText("KM/L");
        showCalculator();
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateClick(1);
            }
        });
    }

    //Hides the calculator and shows the different unt options
    public void backClick() {
        textView2.setVisibility(View.VISIBLE);
        lper100.setVisibility(View.VISIBLE);
        kmperl.setVisibility(View.VISIBLE);
        ukmpg.setVisibility(View.VISIBLE);
        usmpg.setVisibility(View.VISIBLE);
        back.setVisibility(View.GONE);
        constext.setVisibility(View.GONE);
        fuelinput.setText("");
        fuelinput.setVisibility(View.GONE);
        distance.setVisibility(View.GONE);
        distanceinput.setText("");
        distanceinput.setVisibility(View.GONE);
        calculate.setVisibility(View.GONE);
        consoutput.setText("");
        consoutput.setVisibility(View.GONE);
        convtype.setText("");
        convtype.setVisibility(View.GONE);
    }

    //Calculates the result based on the chosen type
    public void calculateClick(int numb) {
        String fuel = fuelinput.getText().toString();
        String distance = distanceinput.getText().toString();
        double fueld = 0;
        double distanced = 0;
        double output;
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(layout.getWindowToken(), 0);
        if (!fuel.isEmpty()) {
            fueld = Double.parseDouble(fuel);
        }
        if (!distance.isEmpty()) {
            distanced = Double.parseDouble(distance);
        }
        if (distanced != 0 && fueld != 0) {
            switch (numb) {
                case 0:
                    output = (fueld / distanced) * 100;
                    output = Math.round(output * 100) / 100D;
                    consoutput.setText(String.valueOf(output));
                    break;
                case 1:
                    output = distanced / fueld;
                    output = Math.round(output * 100) / 100D;
                    consoutput.setText(String.valueOf(output));
                    break;
                case 2:
                    output = distanced / fueld;
                    output = Math.round(output * 100) / 100D;
                    consoutput.setText(String.valueOf(output));
                    break;
                case 3:
                    output = distanced / fueld;
                    output = Math.round(output * 100) / 100D;
                    consoutput.setText(String.valueOf(output));
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if(calculate.getVisibility()==View.VISIBLE){
            backClick();
        }
        else{
            super.onBackPressed();
        }
    }
}