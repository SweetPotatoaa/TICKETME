package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.graphics.Color;
=======
import android.content.Intent;
>>>>>>> master
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

<<<<<<< HEAD
        PieChart pieChart   = findViewById(R.id.buttonPieChart);

        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(2014, 420));
        visitors.add(new PieEntry(2015, 475));
        visitors.add(new PieEntry(2016, 410));
        visitors.add(new PieEntry(2017, 400));
        visitors.add(new PieEntry(2018, 300));
        visitors.add(new PieEntry(2019, 360));

        PieDataSet pieDataSet = new PieDataSet(visitors, "Visitors");

        PieData pieData = new PieData(pieDataSet);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieDatas = new PieData(pieDataSet);

        pieChart.setData(pieDatas);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Visitors");
        pieChart.animate();




=======
        findViewById(R.id.buttonPieChart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DepensesPerShop.class));
            }
        });

        findViewById(R.id.buttonBarChart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DepensesByPeriod.class));
            }
        });
>>>>>>> master
    }
}
