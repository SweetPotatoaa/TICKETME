package com.example.loginsqlite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProgramViewHolder {

    ImageView itemImage;
    TextView ticketTitle;
    TextView ticketNumber;
    ProgramViewHolder(View v)
    {
        itemImage = v.findViewById(R.id.imageView);
        ticketTitle = v.findViewById(R.id.textView1);
        ticketNumber = v.findViewById(R.id.textView2);

    }
}