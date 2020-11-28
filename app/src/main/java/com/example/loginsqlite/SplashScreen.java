package com.example.loginsqlite;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;



public class SplashScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
