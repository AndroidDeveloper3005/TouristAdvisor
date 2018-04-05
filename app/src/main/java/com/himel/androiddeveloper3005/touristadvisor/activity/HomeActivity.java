package com.himel.androiddeveloper3005.touristadvisor.activity;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.himel.androiddeveloper3005.touristadvisor.R;
import com.himel.androiddeveloper3005.touristadvisor.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private Toolbar toolbar;

    FirebaseAuth firebaseAuth ;

    // Creating FirebaseAuth.
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();

        // On activity start check whether there is user previously logged in or not.
        if(firebaseAuth.getCurrentUser() == null){

            // Finishing current Profile activity.
            finish();

            // If user already not log in then Redirect to LoginActivity .
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);

            // Showing toast message.
            Toast.makeText(HomeActivity.this, "Please Log in to continue", Toast.LENGTH_LONG).show();

        }
       // firebaseUser = firebaseAuth.getCurrentUser();



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //actionBar.setTitle("Shop");
        loadFragment(new HomeFragment());




    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //actionBar.setTitle("Home");
                    Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_LONG).show();
                    // fragment = new HomeFragment();
                    loadFragment(new HomeFragment());
                    return true;
                case R.id.navigation_trips:
                    //actionBar.setTitle("My Trips");
                    Toast.makeText(getApplicationContext(),"My Trips",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.navigation_me:
                    // actionBar.setTitle("Me");
                    Toast.makeText(getApplicationContext(),"Me",Toast.LENGTH_LONG).show();
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(android.support.v4.app.Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
