package com.example.helloandroid.acitivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloandroid.R;
import com.example.helloandroid.pojo.DummyData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class UniversityActivity extends AppCompatActivity {

    ImageView collegeImage;
    TextView name, address, district, institutionType, women, minority;
    TextView aicteId;

    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);
        collegeImage= findViewById(R.id.university_image_activity);
        name= findViewById(R.id.university_name_activity);
        address= findViewById(R.id.university_address_activity);
        district= findViewById(R.id.district_uni_activity);
        institutionType= findViewById(R.id.institution_type_uni_activity);
        women= findViewById(R.id.woman_uni_activity);
        minority= findViewById(R.id.minority_uni_activity);
        aicteId= findViewById(R.id.aicte_id_acitivity_uni);

        database= FirebaseDatabase.getInstance();
        databaseReference= database.getReference().child("Universities");

        Intent intent= getIntent();
        String clgAicte= intent.getStringExtra("aicteId");
        String id= intent.getStringExtra("id");
        String clgName= intent.getStringExtra("name");
        String clgAddress= intent.getStringExtra("address");
        String clgDistrict= intent.getStringExtra("district");
        String clgInstitutionType= intent.getStringExtra("institutionType");
        String clgWomen= intent.getStringExtra("woman");
        String clgMinority= intent.getStringExtra("minority");

//        name.setText(clgName);
//        address.setText(clgAddress);
        aicteId.setText(clgAicte);
        district.setText(clgDistrict);
        institutionType.setText(clgInstitutionType);
        women.setText(clgWomen);
        minority.setText(clgMinority);

        databaseReference.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    DummyData dummyData= snapshot.getValue(DummyData.class);
                    name.setText(dummyData.getName());
                    address.setText(dummyData.getAddress());
                }else{
                    Toast.makeText(UniversityActivity.this, "No data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}