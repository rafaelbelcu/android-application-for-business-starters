package com.example.belcurafaelstefanapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class TaxesAdapter extends RecyclerView.Adapter<TaxesAdapter.ViewHolder> {

    TaxesData[] myTaxesData;
    Context context;

    public TaxesAdapter(TaxesData[] myTaxesData, Fiscality activity) {
        this.myTaxesData = myTaxesData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.taxes_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TaxesData myTaxesDataList = myTaxesData[position];
        holder.textViewTaxName.setText(myTaxesDataList.getTaxName());
        holder.textViewTaxDefinition.setText(myTaxesDataList.getTaxDefinition());
        holder.taxImage.setImageResource(myTaxesDataList.getTaxImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myTaxesDataList.getTaxName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myTaxesData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView taxImage;
        TextView textViewTaxName;
        TextView textViewTaxDefinition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taxImage = itemView.findViewById(R.id.taxesimage);
            textViewTaxName = itemView.findViewById(R.id.taxtitle);
            textViewTaxDefinition = itemView.findViewById(R.id.taxdefinition);

        }
    }

}
