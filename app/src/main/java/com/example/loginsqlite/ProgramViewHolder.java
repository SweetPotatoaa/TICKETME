package com.example.loginsqlite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProgramViewHolder {

    ImageView itemImage;
    TextView programTitle;
    TextView programDescription;
    ProgramViewHolder(View v)
    {
        itemImage = v.findViewById(R.id.imageView);
        programTitle = v.findViewById(R.id.textView1);
        programDescription = v.findViewById(R.id.textView2);

    }
}