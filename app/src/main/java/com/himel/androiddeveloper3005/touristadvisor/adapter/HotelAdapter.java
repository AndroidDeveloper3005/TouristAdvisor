package com.himel.androiddeveloper3005.touristadvisor.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.himel.androiddeveloper3005.touristadvisor.R;
import com.himel.androiddeveloper3005.touristadvisor.model.Hotels;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private Context context;
    private ArrayList<Hotels> hotels;

    public HotelAdapter(Context context, ArrayList< Hotels>hotelArrayList){
        this.context =context;
        this.hotels=hotelArrayList;


    }

    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.from(parent.getContext()).inflate(R.layout.hotel_card_layout, parent, false);
        HotelViewHolder hotelViewHolder = new HotelViewHolder(view);
        return hotelViewHolder;
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {

        final Hotels hotel = hotels.get(position);
        holder.tvname.setText(hotel.getHname());
        holder.tvprice.setText(""+hotel.getPrice());
        String fulurl = hotel.getImage_url();
//        Picasso.with(context)
//                .load(fulurl)
//                .placeholder(R.drawable.homepic)
//                .error(android.R.drawable.stat_notify_error)
//                .into(holder.ivhotelimage);
//

        Glide.with(context).load(hotels.get(position).getImage_url()).into(holder.ivhotelimage);

    }

    @Override
    public int getItemCount() {


        if (hotels !=null) {
            return hotels.size();
        }
        return 0;
    }


    //viewholder class
    public static  class HotelViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public ImageView ivhotelimage;
        public TextView tvname,tvprice;


        public HotelViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cvHotels);
            ivhotelimage = itemView.findViewById(R.id.ivImgHotels);
            tvname = itemView.findViewById(R.id.tvhotelName);
            tvprice = itemView.findViewById(R.id.tvhotelPrice);
        }
    }


}
