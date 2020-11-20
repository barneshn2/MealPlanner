package com.example.groupl;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AllPlanAdapter extends RecyclerView.Adapter<AllPlanAdapter.ViewHolder> {
    private List<Recipe> dataList = new ArrayList<>();

    public void setDataList(List<Recipe> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_two_plan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Recipe r = dataList.get(position);
        holder.name.setText(r.getName());
        holder.date.setText(new Date(r.getLastUpdate()).toString());
        final  Recipe []r1=new Recipe[1];
        r1[0]=r;
     /*   holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b=new Bundle();
                b.putInt("id",r1[0].getId());
                Intent i=new Intent(holder.itemView.getContext(), EditRecipe.class);
                i.putExtras(b);
                holder.itemView.getContext().startActivity(i);
            }
        });
     */   holder.container.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.white));
        if(r.isChecked()){
            holder.container.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.selected));

        }
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1[0].setChecked(!r1[0].isChecked());
                notifyDataSetChanged();
            }
        });

    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView date;
        View container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.recipeName1);
            date=itemView.findViewById(R.id.recipeDate1);
            container=itemView.findViewById(R.id.container1);





        }
    }
}
