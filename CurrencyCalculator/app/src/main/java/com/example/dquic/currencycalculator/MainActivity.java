package com.example.dquic.currencycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    protected EditText input;
    protected TextView output;
    protected Spinner currType;
    protected int conversionType = 0;
    protected Log d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.curr_in);
        output = (TextView)findViewById(R.id.curr_out);

        // Spinner element
        currType = (Spinner)findViewById(R.id.spinner);

        // Spinner click listener
        currType.setOnItemSelectedListener(this);

        // Spinner drop down elements
        List<String> conversions = new ArrayList<String>();
        conversions.add("Dollars to Euros");
        conversions.add("Euros to Dollars");
        conversions.add("Dollars to Won");
        conversions.add("Won to Dollars");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, conversions);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        currType.setAdapter(dataAdapter);
    }


    public void convert_curr(View view){
        double amount = Double.parseDouble(input.getText().toString());
        double outNum = amount * 0.82;
        String currName;

        Log.d("David","BEfore Switch");
        Toast.makeText(getApplicationContext(), "This is a toast - that is long", Toast.LENGTH_LONG).show();

        switch(conversionType) {
            case 0: outNum = amount * 0.82; currName = "Euros"; break;
            case 1: outNum = amount * 1.23; currName = "Dollars"; break;
            case 2: outNum = amount * 1094.91; currName = "Won"; break;
            case 3: outNum = amount * 0.00091; currName = "Dollars"; break;
            default: outNum = amount * 0.82; currName = "Euros"; break;
        }
        output.setText("You have " + outNum + " " + currName +".");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        conversionType = i;
    }

    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
