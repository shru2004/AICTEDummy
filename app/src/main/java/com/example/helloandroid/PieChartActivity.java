package com.example.helloandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    PieChart pieChart;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        ok= findViewById(R.id.pie_ok);
        pieChart= findViewById(R.id.pieChart);
        database= FirebaseDatabase.getInstance();
        databaseReference= database.getReference("ChartValues");

//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        ArrayList<PieEntry> dataVals= new ArrayList<PieEntry>();
//                        if(snapshot.hasChildren()){
//                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
//                                DataPoint dataPoint= dataSnapshot.getValue(DataPoint.class);
//                                dataVals.add(new PieEntry(dataPoint.getyValue(), dataPoint.getxValue()+""));
//
//                            }
//                            PieDataSet pieDataSet= new PieDataSet(dataVals, "Data");
//                            pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
//                            pieDataSet.setValueTextColor(Color.BLACK);
//                            pieDataSet.setValueTextSize(16f);
//
//                            PieData pieData= new PieData(pieDataSet);
//
//                            pieChart.setData(pieData);
//                            pieChart.getDescription().setText("Pie chart");
//                            pieChart.setCenterText("Chart Data");
//                            pieChart.animate();
//                        }else{
//                            pieChart.clear();
//                            pieChart.invalidate();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//            }
//        });
    }
}