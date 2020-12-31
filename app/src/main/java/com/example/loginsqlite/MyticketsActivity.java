package com.example.loginsqlite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyticketsActivity extends AppCompatActivity {
/*
    ListView lvProgram;
    String[] programName = {"Carrefour","Auchan","Darty","Gifi","Animalist", "Sephora","McDonalds","Intermarché","E.Leclerc","KFC"};
    String[] programDescription = {"5.20€", "3.25€","0.80€","7.90€","2.20€","3.15€","6.85€","5.75€","1.89€","4.99€"};
    int[] programImages = {R.drawable.brioche, R.drawable.brioche, R.drawable.brioche,R.drawable.brioche,R.drawable.brioche,R.drawable.brioche,R.drawable.brioche,R.drawable.brioche,R.drawable.brioche,R.drawable.brioche};

    //pdf
    String[] pdfFiles = {"Ticket 1", "Ticket 2", "Ticket 3", "Ticket 4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytickets);
        lvProgram = findViewById(R.id.lvProgram);
        ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription);
        lvProgram.setAdapter(programAdapter);
    }*/



    ListView pdfListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytickets);
        pdfListView = (ListView) findViewById(R.id.myPDFList);

        String[] pdfFiles = {"Ticket 1", "Ticket 2", "Ticket 3", "Ticket 4"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pdfFiles){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                TextView myText = (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };
        pdfListView.setAdapter(adapter);

        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = pdfListView.getItemAtPosition(position).toString();

                Intent start = new Intent(getApplicationContext(), PDFOpener.class);
                start.putExtra("pdfFileName", item);
                startActivity(start);
            }


        });
    }


}