package com.example.sdaassign4_2020;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Images used are sourced from Firebase Realtime Database.
 * A simple {@link Fragment} subclass.
 * @author Hasan Ashraf
 */
public class BookList extends Fragment {

    //RecyclerView rv;
    //List<BookDetails> bookdetail;
    //DatabaseReference databaseReference;
    LibraryViewAdapter adapter;
    //Button checkOut;
    Context mcontext;

    public BookList() {
        //Empty Constructor used to call upon the BookList Class
    }

    /**
     * OnCreate method that inflates the view based on the recycler view that is created
     * @return root
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_book_list, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.bookView_view);


        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Firebase Recycler View is called and used to populate the fragment
        FirebaseRecyclerOptions<BookDetails> options =
                new FirebaseRecyclerOptions.Builder<BookDetails>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books"), BookDetails.class)
                        .build();

        adapter = new LibraryViewAdapter(options,mcontext);
        recyclerView.setAdapter(adapter);
        return root;
    }

    /**
     * OnStart activity to call up on the library view adapter everytime the book tab is clicked
     */
    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }

    }

    /**
     * OnStop Activity to pull information from the adapter when the a different tab is selected in the fragment layout
     */
    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }

    }
}