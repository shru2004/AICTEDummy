package com.example.helloandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloandroid.R;
import com.example.helloandroid.acitivities.UniversityActivity;
import com.example.helloandroid.pojo.DummyData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UniversitiesAdapter extends RecyclerView.Adapter<UniversitiesAdapter.viewHolder> {

    ArrayList<DummyData> list;
    Context context;

    public UniversitiesAdapter(ArrayList<DummyData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.universities_sample_rv,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        DummyData dummyData=list.get(position);

        Query query= FirebaseDatabase.getInstance().getReference("Universities").orderByChild("aicteId").equalTo(dummyData.getAicteId());

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                holder.name.setText(dummyData.getName());
                holder.collegeId.setText(dummyData.getAicteId());
                holder.address.setText(dummyData.getAddress());
                Picasso.get()
                        .load(dummyData.getImg())
                        .placeholder(R.drawable.aicte_header)
                        .into(holder.imageView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        holder.seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, UniversityActivity.class);
                intent.putExtra("id", dummyData.getId());
                intent.putExtra("aicteId", dummyData.getAicteId());
                intent.putExtra("name", dummyData.getName());
                intent.putExtra("address", dummyData.getAddress());
                intent.putExtra("district", dummyData.getDistrict());
                intent.putExtra("institutionType", dummyData.getInstitutionType());
                String str="";
                String str1="";
                if (dummyData.isWomen()){
                    str= "Yes";
                }else{
                    str= "No";
                }
                if (dummyData.isMinority()){
                    str1= "Yes";
                }else{
                    str1= "No";
                }
                intent.putExtra("woman", str);
                intent.putExtra("minority", str1);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView collegeId, name, address, seeMore;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.universities_sample_img);
            collegeId= itemView.findViewById(R.id.university_sample_college_id);
            name= itemView.findViewById(R.id.universities_sample_name);
            address= itemView.findViewById(R.id.universities_sample_address);
            seeMore= itemView.findViewById(R.id.universities_sample_see_more);
        }
    }
}
