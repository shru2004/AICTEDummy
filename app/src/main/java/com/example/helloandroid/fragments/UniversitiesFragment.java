package com.example.helloandroid.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.helloandroid.R;
import com.example.helloandroid.adapters.UniversitiesAdapter;
import com.example.helloandroid.pojo.DummyAutonomous;
import com.example.helloandroid.pojo.DummyCourse;
import com.example.helloandroid.pojo.DummyData;
import com.example.helloandroid.pojo.DummyFaculty;
import com.example.helloandroid.pojo.DummyOtherApproval;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

public class UniversitiesFragment extends Fragment {

    Button button;
    RecyclerView uniRV;
    ArrayList<DummyData> list;

    public UniversitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_universities, container, false);

        button= view.findViewById(R.id.submit);
//        uniRV= view.findViewById(R.id.universitiesRv);
//        list= new ArrayList<>();
//
//        UniversitiesAdapter universitiesAdapter= new UniversitiesAdapter(list, getContext());
//        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        uniRV.setLayoutManager(layoutManager);
//        uniRV.setNestedScrollingEnabled(false);
//        uniRV.setAdapter(universitiesAdapter);
//
//        FirebaseDatabase.getInstance().getReference("Universities").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list.clear();
//                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
//                    DummyData dummyData= dataSnapshot.getValue(DummyData.class);
//                    list.add(dummyData);
//                }
//                universitiesAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DummyAutonomous dummyAutonomous= new DummyAutonomous();
                dummyAutonomous.setAutonomyTill(new Date().getTime()+"");
                dummyAutonomous.setConferedBy("ABC");

                DummyCourse dummyCourse= new DummyCourse();
                dummyCourse.setCourseId("101");
                dummyCourse.setCourseName("IF");
                dummyCourse.setEnrollment(320);
                dummyCourse.setLevelOfCourse("idk");
                dummyCourse.setClosed(false);

                DummyData dummyData= new DummyData();
                dummyData.setAicteId("10001");
                dummyData.setAddress("Wadala");
                dummyData.setDistrict("Mumbai");
                dummyData.setLevel(dummyCourse.getLevelOfCourse());
                dummyData.setInstitutionType("Government");
                dummyData.setName("VP");
                dummyData.setState("Maharashtra");
                dummyData.setUniversityBoard("AICTE");
                dummyData.setClosed(false);

                DummyFaculty dummyFaculty= new DummyFaculty();
                dummyFaculty.setFacultyId("100001");
                dummyFaculty.setFacultyName("Prerana");
                dummyFaculty.setAppointmentType("Dev jano");
                dummyFaculty.setDesignation("Professor");
                dummyFaculty.setGender("Female");
                dummyFaculty.setDateOfJoining(new Date().getDate()+"");
                dummyFaculty.setAppointmentType("idc");

                DummyOtherApproval dummyOtherApproval= new DummyOtherApproval();
                dummyOtherApproval.setCourseId("403");
                dummyOtherApproval.setNri(true);
                dummyOtherApproval.setApprovedIntake(234);
                dummyOtherApproval.setSeats(123);
                dummyOtherApproval.setLevel(dummyCourse.getLevelOfCourse());

                String key= FirebaseDatabase.getInstance().getReference("Universities").push().getKey();

                FirebaseDatabase.getInstance().getReference()
                        .child("Universities")
                        .child(key)
                        .setValue(dummyData).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        FirebaseDatabase.getInstance().getReference()
                                .child("Courses")
                                .child(dummyCourse.getCourseId())
                                .setValue(dummyCourse).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                FirebaseDatabase.getInstance().getReference()
                                        .child("Universities")
                                        .child(key)
                                        .child("Courses")
                                        .child(dummyCourse.getCourseId())
                                        .setValue(true)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        FirebaseDatabase.getInstance().getReference()
                                                .child("Faculties")
                                                .child(dummyFaculty.getFacultyId())
                                                .setValue(dummyFaculty)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        FirebaseDatabase.getInstance().getReference()
                                                                .child("Universities")
                                                                .child(key)
                                                                .child("Faculties")
                                                                .child(dummyFaculty.getFacultyId())
                                                                .setValue(true)
                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                        FirebaseDatabase.getInstance().getReference()
                                                                                .child("Autonomous")
                                                                                .child(dummyData.getAicteId())
                                                                                .setValue(dummyAutonomous)
                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                    @Override
                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                        FirebaseDatabase.getInstance().getReference()
                                                                                                .child("Universities")
                                                                                                .child(key)
                                                                                                .child("Autonomous")
                                                                                                .setValue(true)
                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                    @Override
                                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                                        FirebaseDatabase.getInstance().getReference()
                                                                                                                .child("Other Approval")
                                                                                                                .child(dummyOtherApproval.getCourseId())
                                                                                                                .setValue(dummyOtherApproval)
                                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                    @Override
                                                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                                                        FirebaseDatabase.getInstance().getReference()
                                                                                                                                .child("Universities")
                                                                                                                                .child(key)
                                                                                                                                .child("Other Approvals")
                                                                                                                                .child("NRI")
                                                                                                                                .setValue(true)
                                                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                    @Override
                                                                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                        Toast.makeText(getContext(), "Finally done", Toast.LENGTH_SHORT).show();
                                                                                                                                    }
                                                                                                                                });
                                                                                                                    }
                                                                                                                });
                                                                                                    }
                                                                                                });
                                                                                    }
                                                                                });
                                                                    }
                                                                });
                                                    }
                                                });
                                    }
                                });
                            }
                        });
                    }
                });

//                FirebaseDatabase.getInstance().getReference("Universities").child(key).setValue(dummyData).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        FirebaseDatabase.getInstance().getReference("Universities").child(key).child("Courses").push().setValue(dummyCourse).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                               FirebaseDatabase.getInstance().getReference("Universities").child(key).child("Faculty").push().setValue(dummyFaculty).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                   @Override
//                                   public void onComplete(@NonNull Task<Void> task) {
//                                       FirebaseDatabase.getInstance().getReference("Universities").child(key).child("Other Approvals").push().setValue(dummyOtherApproval).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                           @Override
//                                           public void onComplete(@NonNull Task<Void> task) {
//                                               FirebaseDatabase.getInstance().getReference("Universities").child(key).child("Autonomous").push().setValue(dummyAutonomous).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                   @Override
//                                                   public void onComplete(@NonNull Task<Void> task) {
//                                                       Toast.makeText(view.getContext(), "DONE......", Toast.LENGTH_SHORT).show();
//                                                   }
//                                               });
//                                           }
//                                       });
//                                   }
//                               });
//                            }
//                        });
//                    }
//                });

            }
        });

        return view;
    }
}