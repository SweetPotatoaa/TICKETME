package com.example.loginsqlite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProgramViewHolder {



    ImageView itemImage;
    TextView nameShop;
   TextView shopType;
   TextView description;




    ProgramViewHolder(View v) {

        itemImage = v.findViewById(R.id.image);
        nameShop = v.findViewById(R.id.nameShop);
        shopType = v.findViewById(R.id.shopType);
        description = v.findViewById(R.id.description);


    }
}