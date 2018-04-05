package com.himel.androiddeveloper3005.touristadvisor.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.himel.androiddeveloper3005.touristadvisor.appconstant.Appconstant;
import com.himel.androiddeveloper3005.touristadvisor.R;
import com.himel.androiddeveloper3005.touristadvisor.adapter.HotelAdapter;
import com.himel.androiddeveloper3005.touristadvisor.model.Hotels;

import java.util.ArrayList;

public class HotelActivity extends AppCompatActivity {
    RecyclerView recyclerViewHotels;
    final String TAG ="MainActivity";
    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<Hotels> hotelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        recyclerViewHotels =(RecyclerView) findViewById(R.id.hotelrecyclerView);
        recyclerViewHotels.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                true);
        recyclerViewHotels.setLayoutManager(manager);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("hotel");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                hotelList = new ArrayList<>();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String hotelName=snapshot.child(Appconstant.HOTEL_NAME).getValue().toString();
                    String address=snapshot.child(Appconstant.ADDRESS).getValue().toString();
                    String imageUrl=snapshot.child(Appconstant.IMAGE_URL).getValue().toString();
                    String placeName=snapshot.child(Appconstant.PLACE_NAME).getValue().toString();
                    String price=snapshot.child(Appconstant.PRICE).getValue().toString();
                    Hotels hotels=new Hotels(placeName,hotelName,address,price,imageUrl);
                    hotelList.add(hotels);


                }

                HotelAdapter adapter = new HotelAdapter(getApplicationContext(), hotelList);
                recyclerViewHotels.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
