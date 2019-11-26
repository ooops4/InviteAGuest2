package com.blaxtation.inviteaguest.ui.bookings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.blaxtation.inviteaguest.BookingDetails;
import com.blaxtation.inviteaguest.R;

import java.util.List;

public class BookingListAdapter extends RecyclerView.Adapter<BookingListAdapter.ViewHolder> {

    public List<bookingsGETSET>bookingsGETSETList;
    public BookingListAdapter(List<bookingsGETSET>bookingsGETSETList){

        this.bookingsGETSETList=bookingsGETSETList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bookings_textview,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.hostname.setText(bookingsGETSETList.get(position).getHostname());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                BookingDetails bookingDetails = new BookingDetails();
                AppCompatActivity activity=(AppCompatActivity) view.getContext();


                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_bookings, bookingDetails).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return bookingsGETSETList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        View mView;
        public TextView hostname;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;

            hostname=mView.findViewById(R.id.bookings_list_hostName);

        }
    }
}
