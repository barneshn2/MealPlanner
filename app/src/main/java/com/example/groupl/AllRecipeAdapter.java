package com.example.groupl;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AllRecipeAdapter extends RecyclerView.Adapter<AllRecipeAdapter.ViewHolder> {
    private List<Recipe> dataList = new ArrayList<>();

    public void setDataList(List<Recipe> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void onCheckboxClick2(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        // Can print the list of things with their contents
        // System.out.println(adapter.toString());
        String str= "";
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox4:
                int viewID = view.getId();
                System.out.println(viewID);
                String checkedMsg, uncheckedMsg, RecipeName;
                RecipeName = "";
                // HOW TO ACCESS RECIPE NAME???
                checkedMsg = RecipeName + " Added";
                uncheckedMsg = "recipe name removed";
                str = checked ? checkedMsg : uncheckedMsg;

        }
        System.out.println("??????");
        System.out.println(str);
        System.out.println("??????");
        // Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_one_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Recipe r = dataList.get(position);
        holder.name.setText(r.getName());
        holder.date.setText(new Date(r.getLastUpdate()).toString());
        final Recipe []r1 = new Recipe[1];
        r1[0] = r;
        holder.itemView.setOnClickListener(new View.OnClickListener() { // GET RID OF THIS IN NEW ADAPTER ALso myight be where i hold the click data
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putInt("id", r1[0].getId());
                Intent i = new Intent(holder.itemView.getContext(), EditRecipe.class);
                i.putExtras(b);
                holder.itemView.getContext().startActivity(i);
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recipeName);
            date = itemView.findViewById(R.id.recipeDate);
        }
    }
}
