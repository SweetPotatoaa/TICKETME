package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MyticketsActivity extends AppCompatActivity {

    ListView lvProgram;
    String[] programName = {"Carrefour","Auchan","Darty","Gifi","Animalist", "Sephora","McDonalds","Intermarché","E.Leclerc","KFC"};
    String[] programDescription = {"5.20€", "3.25€","0.80€","7.90€","2.20€","3.15€","6.85€","5.75€","1.89€","4.99€"};
    int[] programImages = {R.drawable.brioche, R.drawable.brioche, R.drawable.brioche,R.drawable.brioche,R.drawable.brioche,R.drawable.brioche,R.drawable.brioche,R.drawable.brioche,R.drawable.brioche,R.drawable.brioche};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytickets);
        lvProgram = findViewById(R.id.lvProgram);
        ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription);
        lvProgram.setAdapter(programAdapter);
    }




}