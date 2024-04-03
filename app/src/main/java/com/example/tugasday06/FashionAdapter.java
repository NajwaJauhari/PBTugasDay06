package com.example.tugasday06;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FashionAdapter extends RecyclerView.Adapter<FashionAdapter.ViewHolder> {
    private ArrayList<com.example.tugasday6.FashionModel> fashionModel;
    public Context context;
    public FashionAdapter(ArrayList<com.example.tugasday6.FashionModel> fashionModel, Context context) {
        this.fashionModel = fashionModel;
        this.context = context;
    }

    @NonNull
    @Override
    public FashionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_fashion, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FashionAdapter.ViewHolder holder, int position) {
        com.example.tugasday6.FashionModel target = fashionModel.get(position);
        holder.nameFashion.setText(target.getName());
        holder.priceFashion.setText(target.getPrice());
        holder.specificFashion.setText(target.getSpecific());
        holder.imageFashion.setImageResource(target.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", target.getName());
                intent.putExtra("price", target.getPrice());
                intent.putExtra("specific", target.getSpecific());
                intent.putExtra("image", target.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fashionModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameFashion, specificFashion, priceFashion;
        ImageView imageFashion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameFashion = itemView.findViewById(R.id.txtNameFashion);
            specificFashion = itemView.findViewById(R.id.txtSpecificFashion);
            priceFashion = itemView.findViewById(R.id.txtPriceFashion);
            imageFashion = itemView.findViewById(R.id.imgImageFashion);
        }
    }
}
