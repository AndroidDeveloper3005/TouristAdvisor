package com.himel.androiddeveloper3005.touristadvisor.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.himel.androiddeveloper3005.touristadvisor.R;
import com.himel.androiddeveloper3005.touristadvisor.activity.HotelActivity;


public class HomeFragment extends Fragment implements  View.OnClickListener{
    private View v;
    private android.support.v7.widget.Toolbar mToolbar;
    private LinearLayout layoutHotel,layoutFlight,layoutResturent,layoutToDo,layoutForum;
    private Button btnWhere;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_home, container, false);
    /* mToolbar = (android.support.v7.widget.Toolbar) v.findViewById(R.id.toolbarid);
     //((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);

     if (((AppCompatActivity)getActivity()).getSupportActionBar() != null) {
         ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     }*/

        layoutHotel =(LinearLayout) v.findViewById(R.id.hotelLout);
        layoutFlight =(LinearLayout) v.findViewById(R.id.flightLout);
        layoutResturent =(LinearLayout) v.findViewById(R.id.resturentLout);
        layoutToDo =(LinearLayout) v.findViewById(R.id.todoLout);
        layoutForum =(LinearLayout) v.findViewById(R.id.forumLout);
        btnWhere = v.findViewById(R.id.whereBTN);
        //setOnClickListener
        layoutHotel.setOnClickListener(this);
        layoutForum.setOnClickListener(this);
        layoutFlight.setOnClickListener(this);
        layoutResturent.setOnClickListener(this);
        layoutToDo.setOnClickListener(this);
        btnWhere.setOnClickListener(this);



        return v;

    }

    @Override
    public void onClick(View v) {
        if (v == layoutHotel){
            //for fragment getActivity()
            Toast.makeText(getActivity(),"Hotel Selected????",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getActivity(), HotelActivity.class);
            startActivity(i);

        }
        else if(v == layoutFlight){

            Toast.makeText(getActivity(),"Flight Selected????",Toast.LENGTH_LONG).show();

        }
        else if(v == layoutResturent){

            Toast.makeText(getActivity(),"Resturent Selected????",Toast.LENGTH_LONG).show();

        }
        else if(v == layoutToDo){

            Toast.makeText(getActivity(),"ToDo Selected????",Toast.LENGTH_LONG).show();

        }
        else if(v == layoutForum){

            Toast.makeText(getActivity(),"Forum Selected????",Toast.LENGTH_LONG).show();

        }
        else if(v == btnWhere){

            Toast.makeText(getActivity(),"Where To Selected????",Toast.LENGTH_LONG).show();

        }

    }
}
