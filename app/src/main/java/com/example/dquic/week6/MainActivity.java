package com.example.dquic.week6;

import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    protected int[] images = {R.drawable.asd, R.drawable.asdf, R.drawable.asdfg};
    protected ImageView imgViewTravel;
    protected int picNum = 0;
    protected double xaxis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgViewTravel = (ImageView) findViewById(R.id.imgViewTravel);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("First");
        categories.add("Second");
        categories.add("Third");
        ArrayAdapter<String> dataAdapter = new
                ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                categories);
        dataAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void backBtnClick(View view) {
        leftSwipe();
    }

    private void leftSwipe() {
        picNum--;
        if (picNum < 0) {
            picNum = images.length - 1;
        }
        imgViewTravel.setImageResource(images[picNum]);
    }

    private void rightSwipe() {
        picNum++;
        if (picNum >= images.length) {
            picNum = 0;
        }
        imgViewTravel.setImageResource(images[picNum]);
    }

    public void nextBtnClick(View view) {
        rightSwipe();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                xaxis = event.getRawX();
                return true;
            case (MotionEvent.ACTION_UP):
                if (xaxis > event.getRawX()) {
                    leftSwipe();
                } else rightSwipe();

                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    public void bye(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v("Matt", "Was Here");
        switch (item.getItemId()) {
            case R.id.Food:
                startActivity(new Intent(this, Main2Activity.class));
                return true;
            case R.id.Back:
                leftSwipe();
                return true;
            case R.id.Next:
                rightSwipe();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent,
                               View view, int position, long id) {
        String item =
                parent.getItemAtPosition(position).toString();

        switch (item) {
            case "First":
                imgViewTravel.setImageResource(images[0]);
                break;
            case "Second":
                imgViewTravel.setImageResource(images[1]);
                break;
            case "Third":
                imgViewTravel.setImageResource(images[2]);
                break;
            default:
                imgViewTravel.setImageResource(images[0]);
                break;
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}




