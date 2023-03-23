package com.example.test_nikitina;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.List;

public class MusclesAdapter extends RecyclerView.Adapter<MusclesAdapter.MusclesViewHoler> {
    private List<Muscles> mMuscles;
    private final MusclesAdapter.OnMusclesClickListener onClickListener;
    private static int viewHolderCount;
    private int numberItems;
    public MusclesAdapter(List<Muscles> muscles, MusclesAdapter.OnMusclesClickListener onClickListener){
        mMuscles =muscles;
        this.onClickListener = onClickListener;
        viewHolderCount = 0;
    }

    interface OnMusclesClickListener{
        void onMusclesClick(Muscles conn);
    }
    @NonNull
    @Override
    public MusclesViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListitem = R.layout.muscles_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(layoutIdForListitem, parent, false);
        MusclesViewHoler viewHolder = new MusclesViewHoler(contactView);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MusclesViewHoler holder, int position) {
        holder.bind(position);
        Muscles musclesItem = mMuscles.get(position);
        holder.chipId.setText(String.valueOf(musclesItem.getId()));
        holder.chipMuscle.setText(String.valueOf(musclesItem.getName()));

        //click
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                // вызываем метод слушателя, передавая ему данные
                onClickListener.onMusclesClick(musclesItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMuscles.size();
    }

    class MusclesViewHoler extends RecyclerView.ViewHolder {

        Chip chipMuscle;
        TextView chipId;

        public MusclesViewHoler(@NonNull View itemView) {
            super(itemView);
            chipMuscle = itemView.findViewById(R.id.chip_item);
            chipId = itemView.findViewById(R.id.chip_id);
        }
        void bind(int listIndex){/*
            Muscles musclesItem = mMuscles.get(listIndex);
            chipId.setText(String.valueOf(musclesItem.getId()));
            chipMuscle.setText(String.valueOf(musclesItem.getName()));*/
        }
    }
}
