package com.example.sdaassign4_2020;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

    //final EditText emailValidate;
    //final static String memail = "";
    private static final String Email_KEY = "First_Email";
    private static final String Email_NEWKEY = "Last_Email";
    //private static final String HIGH_SCORE_KEY = "HIGH_SCORE_KEY";
    private EditText memail, emailValidate, mid, mname;
    public SharedPreferences mprefs;
    public String entemail;
    Button saveButton, clearButton;

    public Settings() {
        // Required empty public constructor
    }


    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {
        //public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment

        //final View root = inflater.inflate(R.layout.fragment_settings, container, false);

        final View root = inflater.inflate(R.layout.fragment_settings, container, false);

        mprefs = this.getActivity().getPreferences(MODE_PRIVATE);

        //getActivity().setContentView(R.layout.fragment_settings);

        mid = root.findViewById(R.id.borrowerID);
        mname = root.findViewById(R.id.userName);
        memail = root.findViewById(R.id.email);

        memail.setText(String.valueOf(mprefs.getString(Email_NEWKEY, "")));


        //
        saveButton = root.findViewById(R.id.save);
        clearButton = root.findViewById(R.id.clear);


        final String email = memail.getText().toString().trim();

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (null == savedInstanceState) {
            memail.setText(String.valueOf("0"));
        } else {
            memail.setText(savedInstanceState.getString(Email_KEY));
        }

        saveButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                entemail = memail.getText().toString();

                memail.setText(String.valueOf(entemail));


                SharedPreferences.Editor editor = mprefs.edit();
                editor.putString(Email_NEWKEY, entemail);
                editor.apply();

                //memail.setText(String.valueOf(entemail));


                saveButton.addTextChangedListener(new TextWatcher() {
                    public void afterTextChanged(Editable s) {

                        if (email.matches(emailPattern) && s.length() > 0) {

                            Toast.makeText(root.getContext().getApplicationContext(), "valid email address", Toast.LENGTH_SHORT).show();
                            // or
                            //textView.setText("valid email");
                        } else {
                            Toast.makeText(root.getContext().getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                            //or
                            //textView.setText("invalid email");
                        }
                    }

                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        // other stuffs
                    }

                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // other stuffs
                    }
                });
            }
        });




        clearButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                memail.setText("");
                mid.setText("");
                mname.setText("");
            }
        });



        //emailValidate = root.findViewById(R.id.email);

        //final TextView textView = (TextView)findViewById(R.id.text);



        return root;
/*
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putString(GAME_SCORE_KEY,mGameScore.getText().toString());
        }

 */
    }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Email_KEY,memail.getText().toString());
    }

}
