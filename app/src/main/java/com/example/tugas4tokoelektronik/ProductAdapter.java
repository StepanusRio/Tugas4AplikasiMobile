package com.example.tugas4tokoelektronik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private List<DataProduct> results;

    public ProductAdapter() {
        super();
    }

    public ProductAdapter(Context context, List<DataProduct> results) {
        this.context = context;
        this.results = results;
    }
    @NotNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_list_item,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataProduct result = results.get(position);
        holder.MerkProduct.setText(result.getMerk());
        holder.HargaProduct.setText(result.getHarga());
        holder.StockProduct.setText(result.getStok());
        Glide.with(holder.ImgProduct).load(MainActivity.URL+"img/"+result.foto).error(R.drawable.google).into(holder.ImgProduct);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView MerkProduct, HargaProduct, StockProduct;
        public ImageView ImgProduct;
        public ConstraintLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.MerkProduct = (TextView) itemView.findViewById(R.id.MerkProduct);
            this.HargaProduct = (TextView) itemView.findViewById(R.id.HargaProduct);
            this.StockProduct = (TextView) itemView.findViewById(R.id.StockProduct);
            this.ImgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
            this.layout = (ConstraintLayout) itemView.findViewById(R.id.cardView);
        }
    }
}
