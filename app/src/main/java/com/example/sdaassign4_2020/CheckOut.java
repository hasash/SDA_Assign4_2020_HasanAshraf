package com.example.sdaassign4_2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.List;

/**
 * Activity call on variables stored in UserDatails Tab Preferences and BookList Details Stored in the Firebase Database
 * @param @Borrowid, borrowusername, emailid;
 * @author Hasan Ashraf
 */
public class CheckOut extends AppCompatActivity {

    TextView mDisplaySummary, mbookselected, mdate, mavailability;
    Calendar mDateAndTime = Calendar.getInstance();
    FirebaseDatabase Node;
    DatabaseReference refer;
    Button sendbut;
    BookDetails modeldata;
    List<BookDetails> checkdetails;
    DatabaseReference databaseReference;
    Available adapter;

    private static final String TAG = "CheckOut";

    /**
     * OnCreate Methods call upon the xml file for the checkout tab
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        //set the toolbar we have overridden
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //find the summary textview
        mDisplaySummary = findViewById(R.id.orderSummary);

        mbookselected = findViewById(R.id.confirm);
        mdate = findViewById(R.id.date);
        mavailability = findViewById(R.id.availability);

        // Intent used to call the location where the stock information is to be stored
        Intent intent = getIntent();
        String text= intent.getStringExtra("bookdetailsss");

        mbookselected.setText(text);

        // Command to be used to Check if the the book selected is available and can be booked for a certain date in the furture
        // Command lines commented as cant call upon the bookname from the right recycler view option
/*
        // Get a reference to our posts
        databaseReference = FirebaseDatabase.getInstance().getReference("books");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                BookDetails newPost = dataSnapshot.getValue(BookDetails.class);
                mbookselected.setText(newPost.getAuthor());
                mavailability.setText(newPost.getStock());
                String availability = mbookselected.toString();
                //System.out.println("Author: " + newPost.author);
                //System.out.println("Title: " + newPost.title);
                ///System.out.println("Previous Post ID: " + prevChildKey);
                if (availability.equals("yes")){
                    sendbut.setEnabled(true);
                    mdate.setEnabled(false);
                    Log.d(TAG, "test11 ");
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });



 */

        //mbookselected.setText(getText(BookList.class));
        //mbookselected.setText("Book Selected is: " + );

        //getActivity().onBackPressed();

        sendbut = findViewById(R.id.orderButton);

        sendbut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "test3 ");
                Node = FirebaseDatabase.getInstance();
                refer = Node.getReference("borrower");

                // Default used to prove the upload to firebase database works
                String requireddate = "15/12/2021";
                String currentdate = "7/2/2021";
                String currenttime = "8:46";
                String bookname = "Book Name 1";
                String borrowerid =  "465";

                /*
                //Collect the values from text fields and use the commands to upload to the firebase database
                String requireddate = mavailability.getEditText.getText().toString();
                String currentdate = mavailability.getEditText.getText().toString();
                String currenttime = mavailability.getEditText.getText().toString();
                String bookname = mavailability.getEditText.getText().toString();
                String borrowerid = mavailability.getEditText.getText().toString();
*/

                // Pass in all the values that are taken form the fields
                BorrowerInfo upload = new BorrowerInfo(requireddate,currentdate,currenttime,bookname,borrowerid);

                refer.child(borrowerid).setValue(upload);
            }
        });

    }
    /*
    private TextWatcher loginTextWatcher = new TextWatcher() {
        /**
         * TextWatcher user to Call out the delivery address field and check if its is populated or not
         *

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            //String availability = mbookselected.getText().toString();

            if (availability.equals("yes")){
                sendbut.setEnabled(true);
                mdate.setEnabled(false);
                Log.d(TAG, "test11 ");
            }
            else{
                sendbut.setEnabled(false);
                mdate.setEnabled(true);
                Log.d(TAG, "test12 ");
                //ordertype = 1;
            }
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

*/

    /**
     * Calender popup open upon calling the function
     * @param v
     */
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

    /**
     * Date and time field updated from the user selection and posted to the textview available
     */
    private void updateDateAndTimeDisplay() {
        //date time year
        CharSequence currentTime = DateUtils.formatDateTime(this, mDateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME);
        CharSequence SelectedDate = DateUtils.formatDateTime(this, mDateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NUMERIC_DATE | DateUtils.FORMAT_SHOW_YEAR);
        String finalSummary = SelectedDate + " current time is " + currentTime;
        mDisplaySummary.setText(finalSummary);
    }

    /**
     * OnStart activity to call up on the library view adapter everytime the book tab is clicked
     */
    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null) {
            //adapter.startListening();
        }

    }

    /**
     * OnStop Activity to pull information from the adapter when the a different tab is selected in the fragment layout
     */
    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            //adapter.stopListening();
        }

    }
    // Method used to return to the book list home page
    public void booklisthome (View view){
        finish();
    }

}
