package com.example.sdaassign4_2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class CheckOut extends AppCompatActivity {

    TextView mDisplaySummary;
    Calendar mDateAndTime = Calendar.getInstance();
    FirebaseDatabase Node;
    DatabaseReference refer;
    Button sendbut;
    private static final String TAG = "CheckOut";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        //set the toolbar we have overridden
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //find the summary textview
        mDisplaySummary = findViewById(R.id.orderSummary);

        //getActivity().onBackPressed();

        sendbut = findViewById(R.id.orderButton);

        sendbut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "test3 ");
                Node = FirebaseDatabase.getInstance();
                refer = Node.getReference("books");

                refer.setValue("Data Storage");
            }
        });
        /*


         */


    }

    //source SDA_2019 android course examples ViewGroup demo
    public void onDateClicked(View v) {

        DatePickerDialog.OnDateSetListener mDateListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                mDateAndTime.set(Calendar.YEAR, year);
                mDateAndTime.set(Calendar.MONTH, monthOfYear);
                mDateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDateAndTimeDisplay();
            }
        };

        new DatePickerDialog(CheckOut.this, mDateListener,
                mDateAndTime.get(Calendar.YEAR),
                mDateAndTime.get(Calendar.MONTH),
                mDateAndTime.get(Calendar.DAY_OF_MONTH)).show();

    }

    private void updateDateAndTimeDisplay() {
        //date time year
        CharSequence currentTime = DateUtils.formatDateTime(this, mDateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME);
        CharSequence SelectedDate = DateUtils.formatDateTime(this, mDateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NUMERIC_DATE | DateUtils.FORMAT_SHOW_YEAR);
        String finalSummary = SelectedDate + " current time is " + currentTime;
        mDisplaySummary.setText(finalSummary);
    }
}
