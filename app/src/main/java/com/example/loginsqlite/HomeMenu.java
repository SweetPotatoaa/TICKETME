package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeMenu extends AppCompatActivity {

    CardView cardTicket;
    CardView cardStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        cardTicket = findViewById(R.id.cardticket);
        cardStat = findViewById(R.id.cardstat);


        cardTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //permet d'aller à la page MyTickets
                Intent intent = new Intent(getApplicationContext(), MyticketsActivity.class);
                startActivity(intent);
            }
        });

        cardStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //permet d'aller à la page Statistiques
                Intent intent = new Intent(getApplicationContext(), StatActivity.class);
                startActivity(intent);
            }
        });
    }
}