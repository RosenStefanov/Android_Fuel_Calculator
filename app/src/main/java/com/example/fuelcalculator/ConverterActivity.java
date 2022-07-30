package com.example.fuelcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConverterActivity extends AppCompatActivity {
    private Button lper100;
    private Button kmperl;
    private Button ukmpg;
    private Button usmpg;
    private Button back;
    private TextView chosenType;
    private TextView convinfo;
    private EditText convInput;
    private Button converterButton;
    private TextView convText1;
    private TextView convNumb1;
    private TextView convText2;
    private TextView convNumb2;
    private TextView convText3;
    private TextView convNumb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        lper100 = (Button) findViewById(R.id.convlper100Button);
        kmperl = (Button) findViewById(R.id.convkmperlButton);
        ukmpg = (Button) findViewById(R.id.convukmpgButton);
        usmpg = (Button) findViewById(R.id.convusmpgButton);
        back = (Button) findViewById(R.id.convBackButton);
        chosenType = (TextView) findViewById(R.id.convChosenType);
        convinfo = (TextView) findViewById(R.id.converterInfoText);
        convInput = (EditText) findViewById(R.id.convInput);
        converterButton = (Button) findViewById(R.id.convertButton);
        convText1 = (TextView) findViewById(R.id.convText1);
        convNumb1 = (TextView) findViewById(R.id.convNumb1);
        convText2 = (TextView) findViewById(R.id.convtext2);
        convNumb2 = (TextView) findViewById(R.id.convNumb2);
        convText3 = (TextView) findViewById(R.id.convText3);
        convNumb3 = (TextView) findViewById(R.id.convNumb3);
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

    //Hides the different units buttons and shows the converter
    public void showConverter() {
        lper100.setVisibility(View.GONE);
        kmperl.setVisibility(View.GONE);
        ukmpg.setVisibility(View.GONE);
        usmpg.setVisibility(View.GONE);
        convinfo.setVisibility(View.GONE);
        chosenType.setVisibility(View.VISIBLE);
        convInput.setVisibility(View.VISIBLE);
        converterButton.setVisibility(View.VISIBLE);
        convText1.setVisibility(View.VISIBLE);
        convNumb1.setVisibility(View.VISIBLE);
        convText2.setVisibility(View.VISIBLE);
        convNumb2.setVisibility(View.VISIBLE);
        convText3.setVisibility(View.VISIBLE);
        convNumb3.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
    }

    //Shows the converter from L/100 Km
    public void lper100Click() {
        chosenType.setText("Enter the L/100 Km value:");
        convText1.setText("Converted to Km/L:");
        convText2.setText("Converted to UK MPG:");
        convText3.setText("Converted to US MPG:");
        showConverter();
        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                converterClick(0);
            }
        });
    }

    //Shows the converter from Km/L
    public void kmperlClick() {
        chosenType.setText("Enter the Km/L value:");
        convText1.setText("Converted to L/100 Km:");
        convText2.setText("Converted to UK MPG:");
        convText3.setText("Converted to US MPG:");
        showConverter();
        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                converterClick(1);
            }
        });
    }

    //Shows the converter from Uk MPG
    public void ukmpgClick() {
        chosenType.setText("Enter the UK MPG value:");
        convText1.setText("Converted to L/100 Km:");
        convText2.setText("Converted to Km/L:");
        convText3.setText("Converted to US MPG:");
        showConverter();
        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                converterClick(2);
            }
        });
    }

    //Shows the converter from US MPG
    public void usmpgClick() {
        chosenType.setText("Enter the US MPG value:");
        convText1.setText("Converted to L/100 Km:");
        convText2.setText("Converted to Km/L:");
        convText3.setText("Converted to UK MPG:");
        showConverter();
        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                converterClick(3);
            }
        });
    }

    //Hides the converter and shows the different unt options
    public void backClick() {
        convInput.setText("");
        lper100.setVisibility(View.VISIBLE);
        kmperl.setVisibility(View.VISIBLE);
        ukmpg.setVisibility(View.VISIBLE);
        usmpg.setVisibility(View.VISIBLE);
        convinfo.setVisibility(View.VISIBLE);
        chosenType.setText("");
        chosenType.setVisibility(View.GONE);
        convInput.setVisibility(View.GONE);
        converterButton.setVisibility(View.GONE);
        convText1.setText("");
        convText1.setVisibility(View.GONE);
        convNumb1.setText("");
        convNumb1.setVisibility(View.GONE);
        convText2.setText("");
        convText2.setVisibility(View.GONE);
        convNumb2.setText("");
        convNumb2.setVisibility(View.GONE);
        convText3.setText("");
        convText3.setVisibility(View.GONE);
        convNumb3.setText("");
        convNumb3.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
    }

    //Converts from the chosen unit to the other 3
    public void converterClick(int numb) {
        String fuel = convInput.getText().toString();
        double fueld = 0;
        double output;
        if (!fuel.isEmpty()) {
            fueld = Double.parseDouble(fuel);
        }
        if (fueld != 0) {
            switch (numb) {
                case 0:
                    output = 100 / fueld;
                    output = Math.round(output * 100) / 100D;
                    convNumb1.setText(String.valueOf(output));
                    output = 282.481 / fueld;
                    output = Math.round(output * 100) / 100D;
                    convNumb2.setText(String.valueOf(output));
                    output = 235.21 / fueld;
                    output = Math.round(output * 100) / 100D;
                    convNumb3.setText(String.valueOf(output));
                    break;
                case 1:
                    output = 100 / fueld;
                    output = Math.round(output * 100) / 100D;
                    convNumb1.setText(String.valueOf(output));
                    output = 2.82481 * fueld;
                    output = Math.round(output * 100) / 100D;
                    convNumb2.setText(String.valueOf(output));
                    output = 2.352145 * fueld;
                    output = Math.round(output * 100) / 100D;
                    convNumb3.setText(String.valueOf(output));
                    break;
                case 2:
                    output = 282.481 / fueld;
                    output = Math.round(output * 100) / 100D;
                    convNumb1.setText(String.valueOf(output));
                    output = fueld / 2.82481;
                    output = Math.round(output * 100) / 100D;
                    convNumb2.setText(String.valueOf(output));
                    output = fueld * 0.8327;
                    output = Math.round(output * 100) / 100D;
                    convNumb3.setText(String.valueOf(output));
                    break;
                case 3:
                    output = 235.21 / fueld;
                    output = Math.round(output * 100) / 100D;
                    convNumb1.setText(String.valueOf(output));
                    output = fueld / 2.352145;
                    output = Math.round(output * 100) / 100D;
                    convNumb2.setText(String.valueOf(output));
                    output = fueld * 1.201;
                    output = Math.round(output * 100) / 100D;
                    convNumb3.setText(String.valueOf(output));
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if(converterButton.getVisibility() == View.VISIBLE)
        {
            convInput.setText("");
            lper100.setVisibility(View.VISIBLE);
            kmperl.setVisibility(View.VISIBLE);
            ukmpg.setVisibility(View.VISIBLE);
            usmpg.setVisibility(View.VISIBLE);
            convinfo.setVisibility(View.VISIBLE);
            chosenType.setText("");
            chosenType.setVisibility(View.GONE);
            convInput.setVisibility(View.GONE);
            converterButton.setVisibility(View.GONE);
            convText1.setText("");
            convText1.setVisibility(View.GONE);
            convNumb1.setText("");
            convNumb1.setVisibility(View.GONE);
            convText2.setText("");
            convText2.setVisibility(View.GONE);
            convNumb2.setText("");
            convNumb2.setVisibility(View.GONE);
            convText3.setText("");
            convText3.setVisibility(View.GONE);
            convNumb3.setText("");
            convNumb3.setVisibility(View.GONE);
            back.setVisibility(View.GONE);
        }
        else{
            super.onBackPressed();
        }
    }
}