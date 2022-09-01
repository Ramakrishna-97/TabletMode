package com.example.tabletmode;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.userHolder> {
    List<ModelClass> modelClassList;

    public AdapterClass(List<ModelClass> modelClassList){
        this.modelClassList=modelClassList;
    }
    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);
        return new userHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.fname.setText("FirstName:"+modelClassList.get(position).getFname());
        holder.mail.setText("Mail:"+modelClassList.get(position).getMail());
        holder.mobile.setText("Mobile:"+modelClassList.get(position).getMobile());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentB,new FragmentB(modelClassList.get(position).getFname(),modelClassList.get(position).getLname(),modelClassList.get(position).getMail(),modelClassList.get(position).getMobile(),modelClassList.get(position).getDesg(),modelClassList.get(position).getDoj())).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class userHolder extends RecyclerView.ViewHolder {
        TextView fname,mail,mobile;
        TextView count;
        public userHolder(@NonNull View itemView) {
            super(itemView);
            fname=itemView.findViewById(R.id.displayname);
            mail=itemView.findViewById(R.id.displayemail);
            mobile=itemView.findViewById(R.id.displaycontact);
            count=itemView.findViewById(R.id.countno);
        }
    }
}
