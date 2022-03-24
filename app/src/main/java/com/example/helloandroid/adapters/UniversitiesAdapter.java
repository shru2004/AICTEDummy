package com.example.helloandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloandroid.R;
import com.example.helloandroid.pojo.DummyData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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

        Query query= FirebaseDatabase.getInstance().getReference("Universities").orderByChild("uniId").equalTo(dummyData.getUniId());

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                holder.name.setText(dummyData.getName());
                holder.collegeId.setText(dummyData.getUniId());
                holder.address.setText(dummyData.getAddress());
                holder.imageView.setImageResource(R.drawable.aicte_header);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        FirebaseDatabase.getInstance().getReference("Universities").child(dummyData.getId()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                DummyData dummyData1= snapshot.getValue(DummyData.class);
//                holder.name.setText(dummyData1.getName()+",,,");
//                holder.collegeId.setText(dummyData1.getUniId()+"bn");
//                holder.address.setText(dummyData1.getAddress()+"hgy");
//                holder.imageView.setImageResource(R.drawable.aicte_header);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView collegeId, name, address;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.universities_sample_img);
            collegeId= itemView.findViewById(R.id.university_sample_college_id);
            name= itemView.findViewById(R.id.universities_sample_name);
            address= itemView.findViewById(R.id.universities_sample_address);
        }
    }
}
