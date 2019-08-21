package com.allan.laptopgaming.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allan.laptopgaming.Model.Laptop;
import com.allan.laptopgaming.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListLaptopAdapter extends RecyclerView.Adapter<ListLaptopAdapter.ListViewHolder>{

    private Context ctx;
    private ArrayList<Laptop> listLaptop;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Laptop obj, int position);
    }

    public ListLaptopAdapter(Context context, ArrayList<Laptop> list) {
        ctx = context;
        this.listLaptop = list;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laptop, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final Laptop laptop = listLaptop.get(position);
        Glide.with(holder.itemView.getContext())//With: Memasukkan Context
                .load(laptop.getLaptopImage())  //Load: memasukkan Sumber Gambar
                .apply(new RequestOptions().override(55, 55))//Apply: Mengatur tinggi dan lebar gambar
                .into(holder.imgPhoto); // Memasukan ImageView 
        holder.tvName.setText(laptop.getLaptopName());
        holder.tvPrice.setText(laptop.getLaptopPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(v, laptop, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listLaptop.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayoutItem;
        ImageView imgPhoto;
        TextView tvName, tvPrice;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutItem = itemView.findViewById(R.id.linearItem);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvPrice = itemView.findViewById(R.id.tv_item_from);
        }
    }


}
