package com.example.dateyoureve.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.dateyoureve.Activities.AuthActivities.LoginActivity;
import com.example.dateyoureve.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    // firebase authentication credentials
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // activity_login layout will be loaded

        // getting instance of Firebase
        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser(); // Current User


    }

    @Override
    protected void onStart() {
        super.onStart();
        // If user does exist then simply send that to home
        if(mCurrentUser != null)
        {
            sendUserToHome();
        }
        // Otherwise do proper authentication using OTP Methodology
        // when user will enter into the application, will be rediredted to LoginActivity
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        finish();
    }

    // When User exists
    private void sendUserToHome() {
        Intent homeIntent = new Intent(MainActivity.this, LoginActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }
}