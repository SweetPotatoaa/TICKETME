package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class DepensesPerShop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depenses_per_shop);

        PieChart pieChart   = findViewById(R.id.buttonPieChart);

        ArrayList<PieEntry> intermarche = new ArrayList<PieEntry>();
        ArrayList<PieEntry> animalis = new ArrayList<PieEntry>();

PieEntry animals = new PieEntry(100);





        intermarche.add(new PieEntry(22, "Animalis"));
        intermarche.add(new PieEntry(1500, "Darty"));
        intermarche.add(new PieEntry(35, "Sephora"));
        intermarche.add(new PieEntry(156, "Auchan"));
        intermarche.add(new PieEntry(15, "Gifi"));


        PieDataSet pieDataSet = new PieDataSet(intermarche,"Magasins");



        PieData pieData = new PieData(pieDataSet);

       pieData.setHighlightEnabled(false);



        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(10f);



        PieData pieDatas = new PieData(pieDataSet);



        pieChart.setData(pieDatas);

        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Expenses");
        pieChart.animate();




    }
}


