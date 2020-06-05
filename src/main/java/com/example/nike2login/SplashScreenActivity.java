package com.example.nike2login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nike2login.LoginRegisterFlow.ChooseLoginRegistrationActivity;
import com.google.firebase.auth.FirebaseAuth;

//this activity has one job: if the user is logged in, directly go to the main activity.
//if the user is not logged in, go to ChooseLoginRegister activity
public class SplashScreenActivity extends AppCompatActivity {


    public static boolean started = false;
    private FirebaseAuth mAuth;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this variable contains all the information that is associated with the user that is currently logged in (like the id, email, name, etc)
        mAuth = FirebaseAuth.getInstance();

        //if a user is logged in
        if(mAuth.getCurrentUser() != null){
            Intent intent = new Intent(getApplication(), MainActivity.class);
            //erase everything that is on top of this activity
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        } else {
            Intent intent = new Intent(getApplication(), ChooseLoginRegistrationActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        }
    }
}
