package com.example.sdaassign4_2020;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

/*
 * Adapter Class used to take in recycler view for the content stored in the firebase realtime directory
 * @author Hasan Ashraf 2020
 * @param
 *
 */
public class LibraryViewAdapter extends FirebaseRecyclerAdapter<BookDetails,LibraryViewAdapter.ViewHolder> {
    //List<BookDetails> bookdetail;
    private Context mmContext;
    Button Sendbtn;

    /*
     *  Adapter Method creates an output used to simplify
     */
    public LibraryViewAdapter(FirebaseRecyclerOptions<BookDetails> options, Context mmContext) {
        super(options);
        this.mmContext = mmContext;
        //this.bookdetail = bookdetail;



    }
    /*
     * On View Holder calls the xml that allows the view to be created inside the fragment that is seleccted
     * @return ViewHolder xml
     */
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    /*
     * On Bind Holder allows the view to be infiltrated with the content saved in the firebase realtime database
     * @param Viewholder, position, model
     * @return holder with all the items called from the database
     */
    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, final int position, @NonNull final BookDetails model) {
        //Log.d(TAG, "onBindViewHolder: was called");
        holder.authortext.setText(model.getAuthor());
        holder.titleText.setText(model.getTitle());
        //holder.authorText.setText(model.);
        //BookDetails bookdets= bookdetail.get(position);
        Glide.with(holder.imageItem.getContext())
                .load(model.getImageUrl())
                .into(holder.imageItem);
/*
        holder.checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(mmContext,position, Toast.LENGTH_SHORT).show();
                //...
                Intent myOrder = new Intent (mmContext, CheckOut.class);
                mmContext.startActivity(myOrder);
            }
        });

 */
        //Intent myIntent = new Intent(this.mmContext.getApplicationContext(),CheckOut.class);
        //myIntent.putExtra("bookdetailsss", model.getStock());
        //myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //mmContext.startActivity(myIntent);

        //holder.mbookselected.setText(model.getStock());




    }
    /*
     * Viewholder call on the position and layout struture of the different fields from the recycler view xml file
     * @return recycler view
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageItem;
        TextView authortext;
        TextView titleText;
        Button checkOut;
        RelativeLayout itemParentLayout;
        TextView mbookselected;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            //grab the image, the text and the layout id's
            imageItem = itemView.findViewById(R.id.bookImage);
            authortext = itemView.findViewById(R.id.authText);
            titleText = itemView.findViewById(R.id.bookTitle);
            checkOut = itemView.findViewById(R.id.out_button);
            itemParentLayout = itemView.findViewById(R.id.listItemLayout);
            mbookselected = itemView.findViewById(R.id.confirm);
        }


    }
}


