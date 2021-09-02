package com.joule.stepviewapp.coor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joule.stepviewapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSlider extends RecyclerView.Adapter<AdapterSlider.viewHolder> {

    ArrayList<DataClass> dataClasses;
    Context context;

    public AdapterSlider(ArrayList<DataClass> dataClasses, Context context) {
        this.dataClasses = dataClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Picasso.with(context)
                .load(dataClasses.get(position).getUrl())
                .fit()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataClasses.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageUrl);

        }
    }
}
