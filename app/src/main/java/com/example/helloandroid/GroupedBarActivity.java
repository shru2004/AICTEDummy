package com.example.helloandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GroupedBarActivity extends AppCompatActivity {

    Button ok;
    FirebaseDatabase database;
    DatabaseReference ref1, ref2, ref3;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grouped_bar);
        ok= findViewById(R.id.bar_ok);
        database= FirebaseDatabase.getInstance();
        ref1= database.getReference("ChartValues");
        ref2= database.getReference("ChartValues2");
        ref3= database.getReference("ChartValues3");
        barChart= findViewById(R.id.barChart2);

//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                ArrayList<BarEntry> dataVals1 = new ArrayList<BarEntry>();
//                ArrayList<BarEntry> dataVals2 = new ArrayList<BarEntry>();
//                ArrayList<BarEntry> dataVals3 = new ArrayList<BarEntry>();
//
//                final BarDataSet[] barDataSet1 = new BarDataSet[1];
//                final BarDataSet[] barDataSet2 = new BarDataSet[1];
//
//                ref1.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.hasChildren()){
//                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
//                                DataPoint dataPoint= dataSnapshot.getValue(DataPoint.class);
//                                dataVals1.add(new BarEntry(dataPoint.getxValue(), dataPoint.getyValue()));
//                            }
//                            barDataSet1[0] = new BarDataSet(dataVals1, "Data1");
//                            barDataSet1[0].setColor(Color.RED);
//                        }else{
//                            Toast.makeText(GroupedBarActivity.this, "sqvAHXZJN WDQNSAXZ", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//                ref2.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.hasChildren()){
//                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
//                                DataPoint dataPoint= dataSnapshot.getValue(DataPoint.class);
//                                dataVals2.add(new BarEntry(dataPoint.getxValue(), dataPoint.getyValue()));
//                            }
//                            barDataSet2[0] = new BarDataSet(dataVals2, "Data1");
//                            barDataSet2[0].setColor(Color.YELLOW);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//                BarData barData= new BarData(barDataSet1[0], barDataSet2[0]);
//                barChart.setData(barData);
//
//                String[] years= new String[]{
//                        "2014", "2015", "2016", "2017"
//                };
//                XAxis xAxis= barChart.getXAxis();
//                xAxis.setValueFormatter(new IndexAxisValueFormatter(years));
//                xAxis.setCenterAxisLabels(true);
//                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//                xAxis.setGranularity(1);
//                xAxis.setGranularityEnabled(true);
//
//                barChart.setDragEnabled(true);
//                barChart.setVisibleXRangeMaximum(3);
//
//                float barSpace= 0.08f;
//                float groupSpace= 0.44f;
//                barData.setBarWidth(0.10f);
//
//                barChart.getXAxis().setAxisMinimum(0);
//                barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace, barSpace)*7);
//                barChart.getAxisLeft().setAxisMinimum(0);
//                barChart.groupBars(0, groupSpace, barSpace);
//
//                barChart.invalidate();
//
//
//                barChart.getDescription().setText("Bar chart");
//                barChart.animateY(3000);
//
////                ref1.addValueEventListener(new ValueEventListener() {
////                    @Override
////                    public void onDataChange(@NonNull DataSnapshot snapshot) {
////                        if(snapshot.hasChildren()){
////                            ArrayList<BarEntry> dataVals1= new ArrayList<BarEntry>();
////                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
////                                DataPoint dataPoint= dataSnapshot.getValue(DataPoint.class);
////                                dataVals1.add(new BarEntry(dataPoint.getxValue(), dataPoint.getyValue()));
////                            }
////                            addData(dataVals1);
//////                            barDataSet[0] = new BarDataSet(dataVals1, "Data1");
//////                            barDataSet[0].setColor(Color.RED);
////                        }
////                    }
////
////                    @Override
////                    public void onCancelled(@NonNull DatabaseError error) {
////
////                    }
////                });
////
////                ref2.addValueEventListener(new ValueEventListener() {
////                    @Override
////                    public void onDataChange(@NonNull DataSnapshot snapshot) {
////                        if(snapshot.hasChildren()){
////                            ArrayList<BarEntry> dataVals2= new ArrayList<BarEntry>();
////                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
////                                DataPoint dataPoint= dataSnapshot.getValue(DataPoint.class);
////                                dataVals2.add(new BarEntry(dataPoint.getxValue(), dataPoint.getyValue()));
////                            }
////                            barDataSet[1]= new BarDataSet(dataVals2, "Data2");
////                            barDataSet[1].setColor(Color.BLUE);
////                        }
////                    }
////
////                    @Override
////                    public void onCancelled(@NonNull DatabaseError error) {
////
////                    }
////                });
////
////                ref3.addValueEventListener(new ValueEventListener() {
////                    @Override
////                    public void onDataChange(@NonNull DataSnapshot snapshot) {
////                        if(snapshot.hasChildren()){
////                            ArrayList<BarEntry> dataVals3= new ArrayList<BarEntry>();
////                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
////                                DataPoint dataPoint= dataSnapshot.getValue(DataPoint.class);
////                                dataVals3.add(new BarEntry(dataPoint.getxValue(), dataPoint.getyValue()));
////                            }
////                            barDataSet[2]= new BarDataSet(dataVals3, "Data3");
////                            barDataSet[2].setColor(Color.YELLOW);
////                        }
////                    }
////
////                    @Override
////                    public void onCancelled(@NonNull DatabaseError error) {
////
////                    }
////                });
////
//////                BarData barData= new BarData(barDataSet1, barDataSet2, barDataSet3);
//////                barChart.setData(barData);
//////
//                String[] years= new String[]{
//                        "2014", "2015", "2016", "2017"
//                };
//                XAxis xAxis= barChart.getXAxis();
//                xAxis.setValueFormatter(new IndexAxisValueFormatter(years));
//                xAxis.setCenterAxisLabels(true);
//                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//                xAxis.setGranularity(1);
//                xAxis.setGranularityEnabled(true);
//
//                barChart.setDragEnabled(true);
//                barChart.setVisibleXRangeMaximum(3);
//
//                float barSpace= 0.08f;
//                float groupSpace= 0.44f;
//                barData.setBarWidth(0.10f);
//
//                barChart.getXAxis().setAxisMinimum(0);
//                barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace, barSpace)*7);
//                barChart.getAxisLeft().setAxisMinimum(0);
//                barChart.groupBars(0, groupSpace, barSpace);
//
//                barChart.invalidate();
//
//
//                barChart.getDescription().setText("Bar chart");
//                barChart.animateY(3000);
////            }
////
////            private void addData(ArrayList<BarEntry> dataVals1) {
////
////
////
//            }
//        });
    }
}