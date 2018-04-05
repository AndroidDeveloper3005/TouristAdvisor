package com.himel.androiddeveloper3005.touristadvisor.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.himel.androiddeveloper3005.touristadvisor.R;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    EditText email, password ;
    Button signUp;
    TextView goLogin ;
    String EmailHolder, PasswordHolder ;
    ProgressDialog progressDialog;
    final int totalProgressTime = 500;


    FirebaseAuth firebaseAuth ;

    // Creating Boolean variable that holds EditText is empty or not status.
    Boolean EditTextStatus ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        email = (EditText)findViewById(R.id.EditText_User_EmailID);
        password = (EditText)findViewById(R.id.EditText_User_Password);
        signUp = (Button)findViewById(R.id.Button_SignUp);
        goLogin = (TextView)findViewById(R.id.signupfromlogin);


        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(RegistrationActivity.this);
        signUp.setOnClickListener(this);
        goLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==signUp){
            CheckEditTextIsEmptyOrNot();
            // If EditText is true then this block with execute.
            if(EditTextStatus){

                // If EditText is not empty than UserRegistrationFunction method will call.
                UserRegistrationMethod();

            }
            // If EditText is false then this block with execute.
            else {

                Toast.makeText(RegistrationActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

            }

        }
        else if (v==goLogin ){
            // Finishing current Main Activity.
            finish();

            // Opening the Login Activity using Intent.
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);

        }




    }

    public void CheckEditTextIsEmptyOrNot(){

        // Getting name and email from EditText and save into string variables.
        EmailHolder = email.getText().toString().trim();
        PasswordHolder = password.getText().toString().trim();

        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {

            EditTextStatus = false;

        }
        else {

            EditTextStatus = true ;
        }

    }

    // Creating UserRegistrationFunction

    public void UserRegistrationMethod(){

        // Showing progress dialog at user registration time.

        progressDialog.setMessage("Please Wait, We are Registering Your Data on Server");
        progressDialog.show();
        final CustomThread  thread = new CustomThread();
        thread.start();

        // Creating createUserWithEmailAndPassword method and pass email and password inside it.
        firebaseAuth.createUserWithEmailAndPassword(EmailHolder, PasswordHolder).
                addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // Checking if user is registered successfully.
                        if(task.isSuccessful()){

                            // If user registered successfully then show this toast message.
                            Toast.makeText(RegistrationActivity.this,"User Registration Successfully",Toast.LENGTH_LONG).show();

                        }else{

                            // If something goes wrong.
                            Toast.makeText(RegistrationActivity.this,"Something Went Wrong.",Toast.LENGTH_LONG).show();
                        }

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                    }
                });

    }
    class CustomThread  extends Thread{

        @Override
        public void run() {
            int jumpTime = 0;

            while(jumpTime < totalProgressTime) {
                try {
                    sleep(1000);
                    jumpTime += 1;
                    progressDialog.setProgress(jumpTime);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
