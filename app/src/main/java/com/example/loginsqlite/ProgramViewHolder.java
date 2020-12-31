package com.example.loginsqlite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProgramViewHolder {


    TextView shop;
    TextView date;
    TextView id;

    ProgramViewHolder(View v)
    {

        shop = v.findViewById(R.id.textView1);
        date = v.findViewById(R.id.textView2);

    }
}