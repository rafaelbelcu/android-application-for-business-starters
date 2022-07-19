package com.example.belcurafaelstefanapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EconomicTermsAdapter extends RecyclerView.Adapter<EconomicTermsAdapter.EconomicTermsViewHolder> {
    private ArrayList<EconomicTerms> economicTermsArrayList;
    private Context context;

    public EconomicTermsAdapter(ArrayList<EconomicTerms> economicTermsArrayList, Context context) {
        this.economicTermsArrayList = economicTermsArrayList;
        this.context = context;
    }

    public void filter(ArrayList<EconomicTerms> filterllist) {
        economicTermsArrayList = filterllist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EconomicTermsAdapter.EconomicTermsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.economic_terms_item, parent, false);
        return new EconomicTermsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EconomicTermsAdapter.EconomicTermsViewHolder holder, int position) {
        EconomicTerms modal = economicTermsArrayList.get(position);
        holder.economicTerm.setText(modal.geteconomicterm());
        holder.termDefinition.setText(modal.gettermdefinition());
    }

    @Override
    public int getItemCount() {
        return economicTermsArrayList.size();
    }

    public class EconomicTermsViewHolder extends RecyclerView.ViewHolder {

        private TextView economicTerm, termDefinition;

        public EconomicTermsViewHolder(@NonNull View itemView) {
            super(itemView);
            economicTerm = itemView.findViewById(R.id.economicterm);
            termDefinition = itemView.findViewById(R.id.termdefinition);
        }
    }
}
