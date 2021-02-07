package com.example.sdaassign4_2020;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Main fragment displayed when the app starts
 * A simple {@link Fragment} subclass.
 * @param
 */
public class Welcome extends Fragment {


    public Welcome() {
        // Required empty public constructor
    }

    /*
     * OnCreate View Inflater command used to set the layout based on the fragment welcome xml
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_welcome, container, false);
        return root;
    }

}
