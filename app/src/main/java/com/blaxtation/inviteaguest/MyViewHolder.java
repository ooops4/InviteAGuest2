package com.blaxtation.inviteaguest;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{

    TextView guestname;
    ImageView guestimage;
    View mView;


    public MyViewHolder(@NonNull View itemView){
        super (itemView);
        mView=itemView;





        guestname=(TextView)itemView.findViewById(R.id.guest_name);
        guestimage=(ImageView)itemView.findViewById(R.id.guest_image);



    }

    }