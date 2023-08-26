package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class incom extends AppCompatActivity {


    PieChart pieChart;

    @Override
    protected void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.activity_incom);

        pieChart = findViewById(R.id.pie_chart2);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<String> labi2 = new ArrayList<>();
        labi2.add("salary");
        labi2.add("transfer");
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        double outCome = 0;
        double income = 0;

        DataBaseHelper myDb = new DataBaseHelper(this);
        Cursor res = myDb.getData();
        while (res.moveToNext()) {
            if (res.getString(3).equals(" salary ."))
                income+=Double.parseDouble(res.getString(2));
            if(res.getString(1).equals(" income "))
            if (res.getString(3).equals(" transfer ."))
                outCome+=Double.parseDouble(res.getString(2));
        }
        //for (int i=1;i<10;i++){
        //   float value=(float) (i*10.0);


        PieEntry pieEntry = new PieEntry((float) income, "salary");
        PieEntry pieEntry1 = new PieEntry((float) outCome, "transfer");

        pieEntries.add(pieEntry);
        pieEntries.add(pieEntry1);


        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Amount");

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextSize(20);
        pieChart.setData(new PieData(pieDataSet));

        pieChart.animateXY(2000, 3000);
        pieChart.getDescription().setEnabled(false);

    }
}
