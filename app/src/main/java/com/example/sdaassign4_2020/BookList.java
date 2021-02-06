package com.example.sdaassign4_2020;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Images used are sourced from Public Domain Day 2019.
 * by Duke Law School's Center for the Study of the Public Domain
 * is licensed under a Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * A simple {@link Fragment} subclass.
 * @author Chris Coughlan
 */
public class BookList extends Fragment {

    //RecyclerView rv;
    //List<BookDetails> bookdetail;
    DatabaseReference databaseReference;
    LibraryViewAdapter adapter;
    Button checkOut;

    //public BookList() {
        // Required empty public constructor
    //}

    //ViewPageAdapter adapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_book_list, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.bookView_view);


        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<BookDetails> options =
                new FirebaseRecyclerOptions.Builder<BookDetails>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books"), BookDetails.class)
                        .build();

        adapter = new LibraryViewAdapter(options);
        recyclerView.setAdapter(adapter);

        //DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        //recyclerView.addItemDecoration(decoration);
        //bookdetail = new ArrayList<>();
        //databaseReference = FirebaseDatabase.getInstance().getReference("books");
        //getImageData(recyclerView);


        //adapter.notifyDataSetChanged();

        //adapter.startListening();

        //RecyclerView.setAdapter(adapter);


        return root;
    }


    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }

    }
    /*
    private void getImageData(final RecyclerView recyclerView) {
    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot di : dataSnapshot.getChildren()) {
                BookDetails articleList = di.getValue(BookDetails.class);
                bookdetail.add(articleList);
            }


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });


    }
  */


}

/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_book_list, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.bookView_view);

        //add array for each item
        ArrayList<String> mAuthor = new ArrayList<>();
        ArrayList<String> mTitle = new ArrayList<>();
        ArrayList<Integer> mImageID = new ArrayList<>();

        //simple loop here to add the images to the array without typing each one
        for(int i=1;i<=14;i++) {
            int id = getResources().getIdentifier("sku1000" + i, "drawable",
                    root.getContext().getPackageName());
            mImageID.add(id);
        }

        //adding author and title.
        mAuthor.add("Edgar Rice Burroughs"); mTitle.add("Tarzan and the Golden Lion");
        mAuthor.add("Agatha Christie"); mTitle.add("The Murder on the Links");
        mAuthor.add("Winston S. Churchill"); mTitle.add("The World Crisis");
        mAuthor.add("E.e. cummings"); mTitle.add("Tulips and Chimneys");
        mAuthor.add("Robert Frost"); mTitle.add("New Hampshire");
        mAuthor.add("Kahlil Gibran"); mTitle.add("The Prophet");
        mAuthor.add("Aldous Huxley"); mTitle.add("Antic Hay");
        mAuthor.add("D.H. Lawrence"); mTitle.add("Kangaroo");
        mAuthor.add("Bertrand and Dora Russell"); mTitle.add("The Prospects of Industrial Civilization");
        mAuthor.add("Carl Sandberg"); mTitle.add("Rootabaga Pigeons");
        mAuthor.add("Edith Wharton"); mTitle.add("A Son at the Front");
        mAuthor.add("P.G. Wodehouse"); mTitle.add("The Inimitable Jeeves");
        mAuthor.add("P.G. Wodehouse"); mTitle.add("Leave it to Psmith");
        mAuthor.add("Viginia Woolf"); mTitle.add("Jacob's Room");

        LibraryViewAdapter recyclerViewAdapter = new LibraryViewAdapter(getContext(), mAuthor, mTitle, mImageID);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

 */


    /*

    private StorageReference mstorageref;
    RecyclerView recyclerView;
    //List<ArticleList>articleLists;
    DatabaseReference databaseReference;

    //add array for each item
    ArrayList<String> mAuthor = new ArrayList<>();
    ArrayList<String> mTitle = new ArrayList<>();
    ArrayList<String> mImageID = new ArrayList<>();// check this


//    ArrayList<BookDetails> mImageID = new ArrayList<>();// check this

    public BookList() {
        // Required empty public constructor
    }

    ViewPageAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_book_list, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.bookView_view);


        //protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //recyclerView=root.findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        mImageID = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("books");
        //private void getImageData
        //getImageData();

        //}

/*
        //simple loop here to add the images to the array without typing each one
        for (int i = 1; i <= 14; i++) {
            int id = getResources().getIdentifier("sku1000" + i, "drawable",
                    root.getContext().getPackageName());
        }



            mstorageref = FirebaseStorage.getInstance().getReference().child("books/sku10001.jpg");
/*
        try {
            final File localfile = File.createTempFile("sku1000" + i, "jpg");
            mstorageref.getFile(localfile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(getActivity().getBaseContext(), "Image", Toast.LENGTH_SHORT).show();
                            Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                            ((ImageView)root.findViewById(R.id.bookImage)).setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getActivity().getBaseContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
            mImageID.add(id);
        }



            //adding author and title.
            mAuthor.add("Edgar Rice Burroughs");
            mTitle.add("Tarzan and the Golden Lion");
            mAuthor.add("Agatha Christie");
            mTitle.add("The Murder on the Links");
            mAuthor.add("Winston S. Churchill");
            mTitle.add("The World Crisis");
            mAuthor.add("E.e. cummings");
            mTitle.add("Tulips and Chimneys");
            mAuthor.add("Robert Frost");
            mTitle.add("New Hampshire");
            mAuthor.add("Kahlil Gibran");
            mTitle.add("The Prophet");
            mAuthor.add("Aldous Huxley");
            mTitle.add("Antic Hay");
            mAuthor.add("D.H. Lawrence");
            mTitle.add("Kangaroo");
            mAuthor.add("Bertrand and Dora Russell");
            mTitle.add("The Prospects of Industrial Civilization");
            mAuthor.add("Carl Sandberg");
            mTitle.add("Rootabaga Pigeons");
            mAuthor.add("Edith Wharton");
            mTitle.add("A Son at the Front");
            mAuthor.add("P.G. Wodehouse");
            mTitle.add("The Inimitable Jeeves");
            mAuthor.add("P.G. Wodehouse");
            mTitle.add("Leave it to Psmith");
            mAuthor.add("Viginia Woolf");
            mTitle.add("Jacob's Room");

            LibraryViewAdapter recyclerViewAdapter = new LibraryViewAdapter(getContext(), mAuthor, mTitle, mImageID);
            recyclerView.setAdapter(recyclerViewAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            return root;



    }
/*
    private void getImageData() {
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot di : dataSnapshot.getChildren()) {
                        BookDetails articleList = di.getValue(BookDetails.class);
                        mImageID.add(articleList);
                    }
                    LibraryViewAdapter adapter = new LibraryViewAdapter(getActivity().getApplicationContext(),mImageID);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


*/
