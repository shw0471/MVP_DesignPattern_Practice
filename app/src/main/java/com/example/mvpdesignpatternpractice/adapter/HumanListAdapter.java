package com.example.mvpdesignpatternpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpdesignpatternpractice.R;
import com.example.mvpdesignpatternpractice.model.Human;

import java.util.ArrayList;
import java.util.List;

public class HumanListAdapter extends RecyclerView.Adapter<HumanListAdapter.ViewHolder> {

    private List<Human> humanList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_human, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = humanList.get(position).getName();
        String age = Integer.toString(humanList.get(position).getAge());

        holder.tv_name.setText(name);
        holder.tv_age.setText(age);
    }

    @Override
    public int getItemCount() {
        return humanList.size();
    }

    public void setHumanList(List<Human> list) {
        humanList = list;
        notifyDataSetChanged();
    }

    public void addHuman(Human human) {
        humanList.add(human);
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