package com.example.sdaassign4_2020;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Welcome extends Fragment {


    public Welcome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_welcome, container, false);
        Button checkOut;
        checkOut = root.findViewById(R.id.out_button);

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //Toast.makeText(getContext().mNewContext, mTitle.get(position), Toast.LENGTH_SHORT).show();
                //...
                Intent myOrder = new Intent (getActivity(),CheckOut.class);
                startActivity(myOrder);
            }
        });
        return root;
    }

}
