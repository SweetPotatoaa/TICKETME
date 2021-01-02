package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class DepensesByPeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depenses_by_period);

        BarChart barChart = findViewById(R.id.barChart);

        ArrayList<BarEntry> expensesByPeriod = new ArrayList<>();
        expensesByPeriod.add(new BarEntry(7, 620));
        expensesByPeriod.add(new BarEntry(8, 475));
        expensesByPeriod.add(new BarEntry(9, 510));
        expensesByPeriod.add(new BarEntry(10, 300));
        expensesByPeriod.add(new BarEntry(11, 700));
        expensesByPeriod.add(new BarEntry(12, 460));

        BarDataSet barDataSet = new BarDataSet(expensesByPeriod, "Expenses in euros €");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Expenses by month");
        barChart.animateY(2000);
    }
}