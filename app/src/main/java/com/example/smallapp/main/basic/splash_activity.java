package com.example.smallapp.main.basic;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.smallapp.databinding.ActivitySplashBinding;

import com.example.smallapp.R;

public class splash_activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.activity_splash);

        Intent intent = new Intent(splash_activity.this,MainActivity.class);
        TextView animText;
        animText = findViewById(R.id.textView3);
        Animation bouncemoving = AnimationUtils.loadAnimation(this,R.anim.bouncing_splash);
        animText.startAnimation(bouncemoving);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();

            }
        },5000);

    }


}