package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class outcom extends AppCompatActivity {
  /*
    BarChart barChart;


    @Override
    protected void onCreate(Bundle saved){

        super.onCreate(saved);
        setContentView(R.layout.activity_outcom);

barChart=findViewById(R.id.bar_chart);
ArrayList<BarEntry>  barEntries=new ArrayList<>();


for(int i=1; i<10;i++){

float value =(float) (i*10.0);

BarEntry barEntry=new BarEntry(i,value);
barEntries.add(barEntry);
BarDataSet barDataSet=new BarDataSet(barEntries,"em");
barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
barDataSet.setDrawValues(false);
barChart.setData(new BarData(barDataSet));
barChart.animateY(5000);
barChart.getDescription().setText("outcom");
barChart.getDescription().setTextColor(Color.BLUE);
}

*/


    BarChart barChart;


    @Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.activity_outcom);

        barChart=findViewById(R.id.bar_chart);


        ArrayList<BarEntry> barEntries=new ArrayList<>();
        ArrayList<String> labi=new ArrayList<>();
        labi.add("entertainment");
        labi.add("investment");
        labi.add("purchases");

        labi.add("transfers");

        double entertainmen=0;
        double investment=0;
        double purchases=0;

      double transfers=0;

        DataBaseHelper myDb =new DataBaseHelper(this);
        Cursor res = myDb.getData();
        while (res.moveToNext()) {
            if(res.getString(3).equals(" entertainment ."))
                entertainmen+=Double.parseDouble(res.getString(2));
            if(res.getString(3).equals(" invesment ."))
                investment +=Double.parseDouble(res.getString(2));
            if(res.getString(3).equals(" Purchases ."))
                purchases +=Double.parseDouble(res.getString(2));
            if(res.getString(1).equals(" outcome "))
            if(res.getString(3).equals(" transfer ."))
                transfers +=Double.parseDouble(res.getString(2));
        }
        //for (int i=1;i<10;i++){
        //   float value=(float) (i*10.0);

        BarEntry barEntry=new BarEntry( 0F,(float) entertainmen);
        BarEntry barEntry1=new BarEntry(1F, (float)investment );
        BarEntry barEntry2=new BarEntry( 2F,(float) purchases);

        BarEntry barEntry3=new BarEntry(3F, (float) transfers);

        barEntries.add(barEntry);
        barEntries.add(barEntry1);
        barEntries.add(barEntry2);
        barEntries.add(barEntry3);

        BarDataSet barDataSet=new BarDataSet(barEntries,"Amount");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setDrawValues(false);

        barChart.setData(new BarData(barDataSet));
        barChart.animateY(4000);
        barChart.getDescription().setText("outcom");
        barChart.getDescription().setTextColor(R.color.black);

        XAxis x=barChart.getXAxis();
        x.setValueFormatter(new IndexAxisValueFormatter(labi));
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawAxisLine(true);
        x.setGranularity(1f);
        x.setLabelCount(labi.size());




    }







































    }

















