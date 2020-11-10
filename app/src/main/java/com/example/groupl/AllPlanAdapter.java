package com.example.groupl;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AllPlanAdapter extends RecyclerView.Adapter<AllRecipeAdapter.ViewHolder> {

    public List<Recipe> dataList = new ArrayList<>();

    public void setDataList(List<Recipe> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public Recipe getRecipe(int i) {
        return dataList.get(i);
    }

    @Override
    public String toString() {
        String ret = "\n";
        for (int i = 0; i < dataList.size(); i++) {
            ret += "\n" + dataList.get(i).getName();
            for (int j = 0; j < dataList.get(i).getIngredientsList().size(); j++) {
                ret += "\n  " + dataList.get(i).getIngredientsList().get(j).getContent();
            }
            ret += "\n";
        }
        return ret;
    }

    @NonNull
    @Override
    public AllRecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_two_recipe, parent, false);
        return new AllRecipeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AllRecipeAdapter.ViewHolder holder, int position) {
        Recipe r = dataList.get(position);
        holder.name.setText(r.getName());
        //holder.date.setText(new Date(r.getLastUpdate()).toString());
        final  Recipe []r1=new Recipe[1];
        r1[0]=r;
         // GET RID OF THIS IN NEW ADAPTER ALso might be where i hold the click data
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        //TextView date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.recipeName);
           // date=itemView.findViewById(R.id.recipeDate);
        }
    }

}