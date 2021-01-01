/*package com.example.loginsqlite;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProgramAdapter extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] ticketName;
    String[] ticketNumber;

    public ProgramAdapter( Context context, String[] ticketName, int[] images, String[] ticketNumber) {
        super(context, R.layout.single_item,R.id.textView1, ticketName);
        this.context = context;
        this.images = images;
        this.ticketName = ticketName;
        this.ticketNumber = ticketNumber;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View singleItem = convertView;
        ProgramViewHolder holder = null;
        if(singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.single_item, parent, false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else{
            holder = (ProgramViewHolder) singleItem.getTag();
        }
        holder.itemImage.setImageResource(images[position]);
        holder.ticketTitle.setText(ticketName[position]);
        holder.ticketNumber.setText(ticketNumber[position]);
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"You clicked:"+ticketName[position],Toast.LENGTH_SHORT).show();
            }
        });
        return singleItem;
    }
}*/
