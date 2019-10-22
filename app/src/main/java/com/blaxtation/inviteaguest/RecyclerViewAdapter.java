package com.blaxtation.inviteaguest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context mContext;
    private List<guest> mguest;


    public RecyclerViewAdapter(Context mContext, List<guest> mguest) {
        this.mContext = mContext;
        this.mguest = mguest;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        final LayoutInflater inflater=LayoutInflater.from(mContext);
        view=inflater.inflate(R.layout.cardview_item_guest,parent,false);













        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.guestname.setText(mguest.get(position).getName());
        holder.guestimage.setImageResource(mguest.get(position).getName());

      //  holder.mView.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View view) {
            //    Toast.makeText(mContext, "you clicked "+(mguest.get(position).getName()), Toast.LENGTH_SHORT).show();
     //       }
      //  });


        //  holder.mView.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //  public void onClick(View view) {

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,GuestDescription.class);
                //intent.putExtra("Title",mguest.get(position).getName());
                mContext.startActivity(intent);


            }
        });





    }

    @Override
    public int getItemCount() {
        return mguest.size();
    }



}
