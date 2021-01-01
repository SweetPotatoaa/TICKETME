package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MyshopActivity extends AppCompatActivity {

    ListView lvProgram;
    String[] shopName = {"Intermarché","Auchan","Darty","Gifi","Animalis", "Sephora","Chanel","E.Leclerc",};
    String[] type = {"Grande surface", "Grande surface","Magasin d'électronique","Magasin bric à brac","Magasin d'animaux","Cosmétique & Beauté","Luxe","Grande surface"};
    String[] description = {"", "","","","","","",""};

    int[] images= {R.drawable.intermarche, R.drawable.auchan, R.drawable.darty,R.drawable.gifi,R.drawable.animalis,R.drawable.sephora,R.drawable.chanel,R.drawable.leclerc};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myshop);
        lvProgram = findViewById(R.id.lvProgram);
        ProgramAdapter programAdapter = new ProgramAdapter(this, shopName,images, description,type);
        lvProgram.setAdapter(programAdapter);
    }
}


