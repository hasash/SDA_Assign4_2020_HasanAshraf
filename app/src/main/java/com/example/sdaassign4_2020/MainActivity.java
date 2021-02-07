package com.example.sdaassign4_2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;

import com.google.android.material.tabs.TabLayout;

/*
 * @author Hasan Ashraf 2020
 */
public class MainActivity extends AppCompatActivity {
    public final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    ViewPager viewPager;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //databaseReference = FirebaseDatabase.getInstance().getReference("books");

        //Toast.makeText(MainActivity.this, "Firebase Connection Sucess", Toast. LENGTH_LONG).show();

        //set the toolbar we have overridden
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.pager);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, getApplicationContext());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



    }
public void ordersnd (View view){
    //Button Sendbtn = findViewById(R.id.out_button);
    //Sendbtn.setOnClickListener(new View.OnClickListener() {
        //@Override
      //  public void onClick(View v) {
            //Toast.makeText(getContext().mNewContext, mTitle.get(position), Toast.LENGTH_SHORT).show();
            //...
            Intent myOrder = new Intent(MainActivity.this, CheckOut.class);
            startActivity(myOrder);

        }


    //});





}

