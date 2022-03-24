package com.example.helloandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart= findViewById(R.id.chart);
        database= FirebaseDatabase.getInstance();
        databaseReference= database.getReference("ChartValues");
        ok= findViewById(R.id.ok);

//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        ArrayList<BarEntry> dataVals= new ArrayList<BarEntry>();
//                        if(snapshot.hasChildren()){
//                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
//                                DataPoint dataPoint= dataSnapshot.getValue(DataPoint.class);
//                                dataVals.add(new BarEntry(dataPoint.getxValue(), dataPoint.getyValue()));
//
//                            }
//
//                            BarDataSet barDataSet= new BarDataSet(dataVals, "Data");
//                            barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
//                            barDataSet.setValueTextColor(Color.BLACK);
//                            barDataSet.setValueTextSize(16f);
//
//                            BarData barData= new BarData(barDataSet);
//
//                            barChart.setFitBars(true);
//                            barChart.setData(barData);
//                            barChart.getDescription().setText("Bar chart");
//                            barChart.animateY(3000);
//
//                        }else{
//                            barChart.clear();
//                            barChart.invalidate();
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