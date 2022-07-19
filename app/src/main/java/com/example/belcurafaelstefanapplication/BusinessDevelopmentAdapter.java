package com.example.belcurafaelstefanapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BusinessDevelopmentAdapter extends RecyclerView.Adapter<BusinessDevelopmentAdapter.BusinessDevVH> {

    List<BusinessDevelopmentClass> businessDevList;

    public BusinessDevelopmentAdapter(List<BusinessDevelopmentClass> businessDevList) {
        this.businessDevList = businessDevList;
    }

    @NonNull
    @Override
    public BusinessDevVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        return new BusinessDevVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessDevVH holder, int position) {
        BusinessDevelopmentClass businessDev = businessDevList.get(position);
        holder.titleTxt.setText(businessDev.getTitle());
        holder.descriptionTxt.setText(businessDev.getDefinition());
        boolean isExpandable = businessDevList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return businessDevList.size();
    }

    public class BusinessDevVH extends RecyclerView.ViewHolder {

        TextView titleTxt, descriptionTxt;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public BusinessDevVH(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.businessdevTitle);
            descriptionTxt = itemView.findViewById(R.id.businessdevDescription);
            linearLayout = itemView.findViewById(R.id.linearlayout);
            expandableLayout = itemView.findViewById(R.id.expandablelayout);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BusinessDevelopmentClass businessDev = businessDevList.get(getAdapterPosition());
                    businessDev.setExpandable(!businessDev.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
