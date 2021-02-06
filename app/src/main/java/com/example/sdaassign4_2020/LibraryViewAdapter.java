package com.example.sdaassign4_2020;

        /*
         * Copyright (C) 2016 The Android Open Source Project
         *
         * Licensed under the Apache License, Version 2.0 (the "License");
         * you may not use this file except in compliance with the License.
         * You may obtain a copy of the License at
         *
         *      http://www.apache.org/licenses/LICENSE-2.0
         *
         * Unless required by applicable law or agreed to in writing, software
         * distributed under the License is distributed on an "AS IS" BASIS,
         * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
         * See the License for the specific language governing permissions and
         * limitations under the License.
         */

        import android.content.Context;
        import android.content.Intent;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.bumptech.glide.Glide;
        import com.firebase.ui.database.FirebaseRecyclerAdapter;
        import com.firebase.ui.database.FirebaseRecyclerOptions;

        import java.util.List;


/*
 * @author Hasan Ashraf 2020
 */
public class LibraryViewAdapter extends FirebaseRecyclerAdapter<BookDetails,LibraryViewAdapter.ViewHolder> {
    //List<BookDetails> bookdetail;
    //Context mContext;
    //public void startListening() {
   // }
    Button Sendbtn;
    public LibraryViewAdapter(FirebaseRecyclerOptions<BookDetails> options) {
        //this.mContext = mContext;
        //this.bookdetail = bookdetail;
        super(options);

    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_list_item, viewGroup, false);

/*
        Sendbtn = view.findViewById(R.id.out_button);
        Sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext().mNewContext, mTitle.get(position), Toast.LENGTH_SHORT).show();
                //...
                Intent myOrder = new Intent(CheckOut.class);
                startActivity(myOrder);

            }
        });
        
 */
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, int position, @NonNull BookDetails model) {
        //Log.d(TAG, "onBindViewHolder: was called");
        holder.authortext.setText(model.getAuthor());
        holder.titleText.setText(model.getTitle());
        //holder.authorText.setText(model.);
        //BookDetails bookdets= bookdetail.get(position);
        Glide.with(holder.imageItem.getContext())
                .load(model.getImageUrl())
                .into(holder.imageItem);




    }
/*
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, Bookdetails) {
        //Log.d(TAG, "onBindViewHolder: was called");

        BookDetails bookdets= bookdetail.get(position);
        Glide.with(mContext)
                .load(bookdets.getImageUrl())
                .into(viewHolder.imageItem);

        viewHolder.authorText.setText(bookdets.getAuthor());
        viewHolder.titleText.setText(bookdets.getTitle());
    }


 */

/*
    @Override
    public int getItemCount() {
        return bookdetail.size();
    }

 */




    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageItem;
        TextView authortext;
        TextView titleText;
        Button checkOut;
        RelativeLayout itemParentLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            //grab the image, the text and the layout id's
            imageItem = itemView.findViewById(R.id.bookImage);
            authortext = itemView.findViewById(R.id.authText);
            titleText = itemView.findViewById(R.id.bookTitle);
            checkOut = itemView.findViewById(R.id.out_button);
            itemParentLayout = itemView.findViewById(R.id.listItemLayout);

        }


    }
    /*public void stopListening() {
    }


     */
    //private static final String TAG = "RecyclerViewAdapter";
    //private Context mNewContext;

    //add array for each item\
    //private ArrayList<String> mAuthor;
    //private ArrayList<String> mTitle;
    //private ArrayList<Integer> mImageID;
/*
    LibraryViewAdapter(Context mNewContext, ArrayList<String> author, ArrayList<String> title, ArrayList<Integer> imageId) {
        this.mNewContext = mNewContext;
        this.mAuthor = author;
        this.mTitle = title;
        this.mImageID = imageId;

    }


    //declare methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_list_item, viewGroup, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: was called");

        viewHolder.authorText.setText(mAuthor.get(position));
        viewHolder.titleText.setText(mTitle.get(position));
        viewHolder.imageItem.setImageResource(mImageID.get(position));

        //should check here to see if the book is available.
        viewHolder.checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(mNewContext, mTitle.get(position), Toast.LENGTH_SHORT).show();
                //...
                Intent myOrder = new Intent (mNewContext, CheckOut.class);
                mNewContext.startActivity(myOrder);
            }
        });
    }



    @Override
    public int getItemCount() {
        return mAuthor.size();
    }

    //view holder class for recycler_list_item.xml
    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageItem;
        TextView authorText;
        TextView titleText;
        Button checkOut;
        RelativeLayout itemParentLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            //grab the image, the text and the layout id's
            imageItem = itemView.findViewById(R.id.bookImage);
            authorText = itemView.findViewById(R.id.authorText);
            titleText = itemView.findViewById(R.id.bookTitle);
            checkOut = itemView.findViewById(R.id.out_button);
            itemParentLayout = itemView.findViewById(R.id.listItemLayout);

        }
    }

 */
}

/*

    private static final String TAG = "RecyclerViewAdapter";
    private Context mNewContext;

    //add array for each item\
    private ArrayList<String> mAuthor;
    private ArrayList<String> mTitle;
    private ArrayList<String> mImageID;

//    private ArrayList<BookDetails> mImageID;

    public //LibraryViewAdapter(Context mNewContext, ArrayList<BookDetails> imageId) {
        LibraryViewAdapter(Context mNewContext, ArrayList<String> author, ArrayList<String> title, ArrayList<String> imageId) {

            this.mNewContext = mNewContext;
        //this.mAuthor = author;
        //this.mTitle = title;
        this.mImageID = imageId;

    }

    //declare methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
        return new ViewHolder(view);
    }
    // article list turn to recycler list itesms
/*
    List<ArticleList> mImageID;


    public ArticleAdapter(List<ArticleList> articleLists, Context mNewContext) {
        this.mImageID = articleLists;
        this.mNewContext = mNewContext;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: was called");

        //BookDetails bookList= mImageID.get(position);
        //Glide.with(mNewContext).load(bookList.getImageUrl()).into(viewHolder.imageItem);

        //viewHolder.bookname.setText(bookList.getBookname());

        viewHolder.authorText.setText(mAuthor.get(position));
        viewHolder.titleText.setText(mTitle.get(position));
        //viewHolder.imageItem.setImageResource(mImageID.get(position));

        //should check here to see if the book is available.
        viewHolder.checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(mNewContext, mTitle.get(position), Toast.LENGTH_SHORT).show();
                //...
                Intent myOrder = new Intent (mNewContext, CheckOut.class);
                mNewContext.startActivity(myOrder);
            }
        });

    }






/*
    @Override
    public int getItemCount() {
        return articleLists.size();
    }




    @Override
    public int getItemCount() {
        return mAuthor.size();
    }

    //view holder class for recycler_list_item.xml
    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageItem;
        TextView authorText;
        TextView titleText;
        Button checkOut;
        RelativeLayout itemParentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //grab the image, the text and the layout id's
            imageItem = itemView.findViewById(R.id.bookImage);
            authorText = itemView.findViewById(R.id.authorText);
            titleText = itemView.findViewById(R.id.bookTitle);
            checkOut = itemView.findViewById(R.id.out_button);
            itemParentLayout = itemView.findViewById(R.id.listItemLayout);

        }
    }
    /*
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView articleimg;
        TextView articlename;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            articleimg=itemView.findViewById(R.id.article_image);
            articlename=itemView.findViewById(R.id.article_name);
        }
    }

     */


