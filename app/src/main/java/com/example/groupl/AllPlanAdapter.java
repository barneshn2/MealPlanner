package com.example.groupl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AllPlanAdapter extends RecyclerView.Adapter<AllPlanAdapter.ViewHolder> {
    private List<Plan> dataList = new ArrayList<>();

    public void setDataList(List<Plan> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_one_plan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Plan r=dataList.get(position);
        holder.name.setText(r.getPlanName());
        holder.date.setText(new Date(r.getDate()).toString());
        final  Plan []r1=new Plan[1];
        r1[0]=r;
        holder.deleView.setVisibility(View.GONE);
        holder.container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                holder.deleView.setVisibility(View.VISIBLE);

                return false;
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

        View container,deleView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.recipeName);
            date=itemView.findViewById(R.id.recipeDate);
            container=itemView.findViewById(R.id.container);
          //  deleView=itemView.findViewById(R.id.deletIcon);


        }
    }
}
