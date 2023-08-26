package com.example.project;



import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Chart extends AppCompatActivity {
    BarChart barChart;

    PieChart pieChart;
@Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.activity_chart);

        barChart=findViewById(R.id.bar_chart);
        pieChart=findViewById(R.id.pie_chart);

        ArrayList<BarEntry> barEntries=new ArrayList<>();
        ArrayList<String> labi=new ArrayList<>();
        labi.add("Outcome");
        labi.add("Income");
        ArrayList<PieEntry> pieEntries=new ArrayList<>();
          double outCome=0;
          double income=0;

    DataBaseHelper myDb1 =new DataBaseHelper(Chart.this);

    Cursor res = myDb1.getData();
    while (res.moveToNext()) {
       if(res.getString(1).equals(" income "))
           income+=Double.parseDouble(res.getString(2));
        if(res.getString(1).equals(" outcome "))
            outCome+=Double.parseDouble(res.getString(2));
    }
       //for (int i=1;i<10;i++){
         //   float value=(float) (i*10.0);

            BarEntry barEntry=new BarEntry( 0F,(float) outCome);
            BarEntry barEntry1=new BarEntry(1F, (float) income);

            PieEntry pieEntry=new PieEntry((float) income,"income");
    PieEntry pieEntry1=new PieEntry((float) outCome,"outCome");
            barEntries.add(barEntry);
            barEntries.add(barEntry1);
            pieEntries.add(pieEntry);
           pieEntries.add(pieEntry1);

            BarDataSet barDataSet=new BarDataSet(barEntries,"Amount");
            barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
            barDataSet.setDrawValues(false);

            barChart.setData(new BarData(barDataSet));
            barChart.animateY(2000);
            barChart.getDescription().setText("Employee chart");
            barChart.getDescription().setTextColor(R.color.teal_200);

    XAxis x=barChart.getXAxis();
    x.setValueFormatter(new IndexAxisValueFormatter(labi));
    x.setPosition(XAxis.XAxisPosition.BOTTOM);
x.setDrawAxisLine(false);
x.setGranularity(1f);
x.setLabelCount(labi.size());


            PieDataSet pieDataSet=new PieDataSet(pieEntries,"Amount");

            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieDataSet.setValueTextSize(20);
            pieChart.setData(new PieData(pieDataSet));

            pieChart.animateXY(4000,3000);
            pieChart.getDescription().setEnabled(false);

        }

}
