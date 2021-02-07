package com.example.sdaassign4_2020;

import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;

import static android.content.Context.MODE_PRIVATE;

/**
 * Setting Class used to collect information from user. The data is then saved to the local databse using the shared preferences and is called upon the applicatio when opened
 * The option for save Data and Clear data is avaiable
 * The input for the email field is also checked
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
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXTID = "text3";
    public static final String TEXTEMAIL = "text2";
    public static final String TEXTUSERNAME = "text1";
    private String idtext, emailtext, usernametext;
    Button saveButton, clearButton;

    public Settings() {
        // Required empty public constructor
    }

    /**
     * On Create uses inflater method to call upon the fragment xml file created
     * This displays the variious Edit Text View that is created for the User to input information to
    */
    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_settings, container, false);

        mid = root.findViewById(R.id.borrowerID);
        mname = root.findViewById(R.id.userName);
        memail = root.findViewById(R.id.email);

        saveButton = root.findViewById(R.id.save);
        clearButton = root.findViewById(R.id.clear);

        final String email = memail.getText().toString().trim();
        // to check of the email has the @ and .com values in its field
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        //On Click Listener when the button is pressed
        saveButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                entemail = memail.getText().toString();

                memail.setText(String.valueOf(entemail));

                //saveData to be called to save the information entered by the user to the shared preferences, location should be inside the email validate method
                saveData();
                //memail.setText(String.valueOf(entemail));

                // Check of the email entered is off a valid field and can be saved in the shared preferences
                saveButton.addTextChangedListener(new TextWatcher() {
                    public void afterTextChanged(Editable s) {

                        if (email.matches(emailPattern) && s.length() > 0) {

                            Toast.makeText(root.getContext().getApplicationContext(), "Valid email address", Toast.LENGTH_SHORT).show();
                            //saveData();// SAVE data method to be called here on sucesfull working of the email valid email address
                        } else {
                            Toast.makeText(root.getContext().getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();

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

        loadDate();
        updateview();

        clearButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                memail.setText("");
                mid.setText("");
                mname.setText("");
            }
        });
        return root;
    }

    /**
     * Save Data to the shared prefernces to be used when the avticivty is call upon
     */
    public void saveData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXTID, mid.getText().toString());
        editor.putString(TEXTEMAIL, memail.getText().toString());
        editor.putString(TEXTUSERNAME, mname.getText().toString());
        editor.apply();
        Toast.makeText(this.getActivity(), "DATA SAVED", Toast.LENGTH_SHORT).show();

    }

    public void loadDate(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        idtext = sharedPreferences.getString(TEXTID, "");
        emailtext = sharedPreferences.getString(TEXTEMAIL, "");
        usernametext = sharedPreferences.getString(TEXTUSERNAME, "");

    }
    public void updateview(){
        mid.setText(idtext);
        memail.setText(emailtext);
        mname.setText(usernametext);
    }
}
