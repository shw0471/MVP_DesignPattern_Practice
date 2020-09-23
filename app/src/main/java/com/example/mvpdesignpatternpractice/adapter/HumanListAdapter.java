package com.example.mvpdesignpatternpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpdesignpatternpractice.Model.Human;
import com.example.mvpdesignpatternpractice.R;

import java.util.ArrayList;
import java.util.List;

public class HumanListAdapter extends RecyclerView.Adapter<HumanListAdapter.ViewHolder> {

    private List<Human> humanList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_human, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_name.setText(humanList.get(position).getName());
        holder.tv_age.setText(Integer.toString(humanList.get(position).getAge()));
    }

    @Override
    public int getItemCount() {
        return humanList.size();
    }

    public void setHumanList(List<Human> list) {
        humanList = list;
        notifyDataSetChanged();
    }

    public void addHumanList(List<Human> list) {
        humanList = list;
        notifyItemChanged(getItemCount() - 1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_age;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_age = itemView.findViewById(R.id.tv_age);
        }
    }
}