package com.example.l117student.datediff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    protected EditText in_time1;
    protected EditText in_time2;
    protected Button in_btn;
    protected TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in_btn = (Button)findViewById(R.id.button1);
        in_btn.setOnClickListener(this);
        output = (TextView) findViewById(R.id.output_diff);
        in_time1 = (EditText) findViewById(R.id.time1);
        in_time2 = (EditText) findViewById(R.id.time2);
    }

    @Override
    public void onClick(View view){
        String[] input1 = in_time1.getText().toString().split(":");
        String[] input2 = in_time2.getText().toString().split(":");
        int[] time1 = { Integer.parseInt(input1[0]), Integer.parseInt(input1[1]) };
        int[] time2 = { Integer.parseInt(input2[0]), Integer.parseInt(input2[1]) };
        int hour_diff = 0;
        int minute_diff = 0;
        if(time1[0] > time2[0]){
            hour_diff = time1[0] - time2[0];
            //minute_diff = time1[1] + (60 - time2[1]);
        } else if (time2[0] > time1[0]) {
            hour_diff = time2[0] - time1[0];
            //minute_diff = time2[1] + (60 - time1[1]);
        }
        minute_diff = Math.abs(time1[1] - time2[1]);
        String results = hour_diff + ":" + minute_diff;
        output.setText(results);
    }
}
