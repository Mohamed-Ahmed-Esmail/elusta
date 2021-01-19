package com.example.elusta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.elusta.Model.ServicesPojoModel;
import com.example.elusta.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerView";

    private Context context;
    private List<ServicesPojoModel.AllserviceEntity> list;

    public RecyclerViewAdapter(Context elustaActivity, List<ServicesPojoModel.AllserviceEntity> list) {
        this.context = elustaActivity;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ServicesPojoModel.AllserviceEntity servicesPojoModel = list.get(position);
        holder.tv_name.setText(servicesPojoModel.getName());
        holder.tv_dec.setText(servicesPojoModel.getDescription());
        holder.tv_price.setText(servicesPojoModel.getInspectfee() + "");
        Glide.with(context)
                .load(servicesPojoModel.getIcon())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_name, tv_dec, tv_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_dec = itemView.findViewById(R.id.tv_Description);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }

}
