package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeMenu extends AppCompatActivity {

    EditText e1;

    CardView cardTicket;
    CardView cardStat;
    CardView cardShop;
    CardView cardScanQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        e1 = (EditText)findViewById(R.id.editText);

        cardTicket = findViewById(R.id.cardticket);
        cardStat = findViewById(R.id.cardstat);
        cardShop = findViewById(R.id.cardshop);
        cardScanQR = findViewById(R.id.cardscanQR);


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

        cardShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //permet d'aller à la page My Shop
                Intent intent = new Intent(getApplicationContext(), MyshopActivity.class);
                startActivity(intent);
            }
        });

        cardScanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //permet d'aller à la page Add a new ticket
                Intent intent = new Intent(getApplicationContext(), ScanQRActivity.class);
                startActivity(intent);
            }
        });

    }

    public void send(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute(e1.getText().toString());
    }


}