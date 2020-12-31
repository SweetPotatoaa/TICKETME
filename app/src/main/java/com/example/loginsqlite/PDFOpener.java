package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpener extends AppCompatActivity {

    PDFView myPDFViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f_opener);

        myPDFViewer = (PDFView) findViewById(R.id.pdfViewer);

        String getItem = getIntent().getStringExtra("pdfFileName");

        if(getItem.equals("Ticket 1")){

            myPDFViewer.fromAsset("Becoming a great leader in business.pdf").load();

        }

        if(getItem.equals("Ticket 2")){

            myPDFViewer.fromAsset("Business and Website Traffic.pdf").load();

        }
        if(getItem.equals("Ticket 3")){

            myPDFViewer.fromAsset("How to Build Products That Run Businesses.pdf").load();

        }
        if(getItem.equals("Ticket 4")){

            myPDFViewer.fromAsset("The Entrepreneur's Mindset.pdf").load();

        }



    }
}