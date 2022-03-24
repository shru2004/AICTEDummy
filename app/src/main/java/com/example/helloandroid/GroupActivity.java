package com.example.helloandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.helloandroid.pojo.YearData;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GroupActivity extends AppCompatActivity {

    BarChart barChart;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        barChart= findViewById(R.id.barChart);
        button= findViewById(R.id.ok_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                DataPoint dataPoint= new DataPoint();
//                dataPoint.setStudentPassed(8);
//                dataPoint.setPlacement(3);
//                dataPoint.setIntake(2);
//                dataPoint.setEnrollment(5);
//                dataPoint.setYear(2015);

//                FirebaseDatabase.getInstance().getReference("Uni Dummy").child("Enrollment").child("2016").setValue("7");

//                String key= FirebaseDatabase.getInstance().getReference("Uni Dummy").push().getKey();
//                FirebaseDatabase.getInstance().getReference("Uni Dummy").child("2016").setValue(dataPoint).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        Toast.makeText(GroupActivity.this, "ejhqwsaxznb sqwnax", Toast.LENGTH_SHORT).show();
//                    }
//                });

                BarDataSet barDataSet[]= new BarDataSet[4];

                FirebaseDatabase.getInstance().getReference("Uni Dummy").child("Enrollment").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChildren()){
                            ArrayList<BarEntry> dataVals= new ArrayList<BarEntry>();
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                                YearData yearData= dataSnapshot.getValue(YearData.class);
                                dataVals.add(new BarEntry(1, yearData.getYear2014()));
                                dataVals.add(new BarEntry(2, yearData.getYear2015()));
                                dataVals.add(new BarEntry(3, yearData.getYear2016()));
                            }
                            barDataSet[0]= new BarDataSet(dataVals, "Data1");
                            barDataSet[0].setColor(Color.BLACK);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                FirebaseDatabase.getInstance().getReference("Uni Dummy").child("Intake").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChildren()){
                            ArrayList<BarEntry> dataVals= new ArrayList<BarEntry>();
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                                YearData yearData= dataSnapshot.getValue(YearData.class);
                                dataVals.add(new BarEntry(1, yearData.getYear2014()));
                                dataVals.add(new BarEntry(2, yearData.getYear2015()));
                                dataVals.add(new BarEntry(3, yearData.getYear2016()));
                            }
                            barDataSet[1]= new BarDataSet(dataVals, "Data2");
                            barDataSet[1].setColor(Color.RED);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                FirebaseDatabase.getInstance().getReference("Uni Dummy").child("Placement").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChildren()){
                            ArrayList<BarEntry> dataVals= new ArrayList<BarEntry>();
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                                YearData yearData= dataSnapshot.getValue(YearData.class);
                                dataVals.add(new BarEntry(1, yearData.getYear2014()));
                                dataVals.add(new BarEntry(2, yearData.getYear2015()));
                                dataVals.add(new BarEntry(3, yearData.getYear2016()));
                            }
                            barDataSet[2]= new BarDataSet(dataVals, "Data1");
                            barDataSet[2].setColor(Color.YELLOW);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                FirebaseDatabase.getInstance().getReference("Uni Dummy").child("Student Passed").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChildren()){
                            ArrayList<BarEntry> dataVals= new ArrayList<BarEntry>();
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                                YearData yearData= dataSnapshot.getValue(YearData.class);
                                dataVals.add(new BarEntry(1, yearData.getYear2014()));
                                dataVals.add(new BarEntry(2, yearData.getYear2015()));
                                dataVals.add(new BarEntry(3, yearData.getYear2016()));
                                Toast.makeText(GroupActivity.this, "3ebhsu", Toast.LENGTH_SHORT).show();
                            }
                            barDataSet[3]= new BarDataSet(dataVals, "Data1");
                            barDataSet[3].setColor(Color.BLUE);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


//                FirebaseDatabase.getInstance().getReference("Uni Dummy").addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.hasChildren()) {
//
//                            BarDataSet barDataSet[]=new BarDataSet[4];
//                            int i=0;
//
//                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                                DataPoint dataPoint = dataSnapshot.getValue(DataPoint.class);
//                                ArrayList<BarEntry> dataVals1 = new ArrayList<BarEntry>();
//                                dataVals1.add(new BarEntry(i, dataPoint.getEnrollment()));
//                                dataVals1.add(new BarEntry(i, dataPoint.getIntake()));
//                                dataVals1.add(new BarEntry(i, dataPoint.getPlacement()));
//                                dataVals1.add(new BarEntry(i, dataPoint.getStudentPassed()));
//
//                                barDataSet[i]= new BarDataSet(dataVals1, "Data");
//                                barDataSet[i].setValueTextSize(13f);
//                                i++;
//
////                                ArrayList<BarEntry> dataVals2 = new ArrayList<BarEntry>();
////                                dataVals2.add(new BarEntry(2, dataPoint.getIntake()));
////
////                                ArrayList<BarEntry> dataVals3 = new ArrayList<BarEntry>();
////                                dataVals3.add(new BarEntry(3, dataPoint.getPlacement()));
////
////                                ArrayList<BarEntry> dataVals4 = new ArrayList<BarEntry>();
////                                dataVals4.add(new BarEntry(4, dataPoint.getStudentPassed()));
//
////                                BarDataSet barDataSet1 = new BarDataSet(dataVals1, "Data1");
////                                barDataSet1.setValueTextSize(13f);
////                                barDataSet1.setColor(Color.YELLOW);
////
////                                BarDataSet barDataSet2 = new BarDataSet(dataVals2, "Data2");
////                                barDataSet2.setValueTextSize(13f);
////                                barDataSet2.setColor(Color.RED);
////
////                                BarDataSet barDataSet3 = new BarDataSet(dataVals3, "Data3");
////                                barDataSet3.setValueTextSize(13f);
////                                barDataSet3.setColor(Color.BLUE);
////
////                                BarDataSet barDataSet4 = new BarDataSet(dataVals4, "Data4");
////                                barDataSet4.setValueTextSize(13f);
////                                barDataSet4.setColor(Color.BLACK);
////
////                                BarData barData = new BarData(barDataSet1, barDataSet2, barDataSet3, barDataSet4);
////                                barChart.setData(barData);
////
//                                String[] years = new String[]{
//                                        "2014", "2015", "2016", "2017"
//                                };
//
//                                XAxis xAxis = barChart.getXAxis();
//                                xAxis.setValueFormatter(new IndexAxisValueFormatter(years));
//                                xAxis.setCenterAxisLabels(true);
//                                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//                                xAxis.setGranularity(1);
//                                xAxis.setGranularityEnabled(true);
//
//                                barChart.setDragEnabled(true);
//                                barChart.setVisibleXRangeMaximum(3);
//
//                                float barSpace = 0.02f;
//                                float groupSpace = 0.5f;
//                                barData.setBarWidth(0.15f);
//
//                                barChart.getXAxis().setAxisMinimum(0);
//                                barChart.getXAxis().setAxisMaximum(0 + barChart.getBarData().getGroupWidth(groupSpace, barSpace) * 7);
//                                barChart.getAxisLeft().setAxisMinimum(0);
//                                barChart.groupBars(0, groupSpace, barSpace);
//
//                                barChart.invalidate();
////                                Legend legend= barChart.getLegend();
////                                legend.setTextSize(24f);
////                                xAxis.setTextSize(24f);
//                                barChart.getDescription().setText("Bar chart");
//                                barChart.animateY(3000);
//                                Toast.makeText(GroupActivity.this, "nedbaxizk", Toast.LENGTH_SHORT).show();
//                            }
//                            barDataSet[0].setColor(Color.YELLOW);
//                            barDataSet[1].setColor(Color.RED);
//                            barDataSet[2].setColor(Color.BLUE);
//                            BarData barData = new BarData(barDataSet[0], barDataSet[1], barDataSet[2]);
//                                barChart.setData(barData);
//
//                                String[] years = new String[]{
//                                        "2014", "2015", "2016", "2017"
//                                };
//
//                                XAxis xAxis = barChart.getXAxis();
//                                xAxis.setValueFormatter(new IndexAxisValueFormatter(years));
//                                xAxis.setCenterAxisLabels(true);
//                                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//                                xAxis.setGranularity(1);
//                                xAxis.setGranularityEnabled(true);
//
//                                barChart.setDragEnabled(true);
//                                barChart.setVisibleXRangeMaximum(3);
//
//                                float barSpace = 0.02f;
//                                float groupSpace = 0.5f;
//                                barData.setBarWidth(0.15f);
//
//                                barChart.getXAxis().setAxisMinimum(0);
//                                barChart.getXAxis().setAxisMaximum(0 + barChart.getBarData().getGroupWidth(groupSpace, barSpace) * 7);
//                                barChart.getAxisLeft().setAxisMinimum(0);
//                                barChart.groupBars(0, groupSpace, barSpace);
//
//                                barChart.invalidate();
////                                Legend legend= barChart.getLegend();
////                                legend.setTextSize(24f);
////                                xAxis.setTextSize(24f);
//                                barChart.getDescription().setText("Bar chart");
//                                barChart.animateY(3000);
//                                Toast.makeText(GroupActivity.this, "nedbaxizk", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//
//                });

            }
        });
    }
}