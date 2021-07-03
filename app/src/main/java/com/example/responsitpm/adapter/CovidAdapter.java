package com.example.responsitpm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.responsitpm.R;
import com.example.responsitpm.model.covid.CovidDataItem;

public class CovidAdapter extends RecyclerView.Adapter<CovidAdapter.ViewHolder> {

    private ArrayList<CovidDataItem> covidItem = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<CovidDataItem> items){
        covidItem.clear();
        covidItem.addAll(items);
        notifyDataSetChanged();
    }

    public CovidAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CovidAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidAdapter.ViewHolder holder, int position) {
        holder.tvTanggal.setText(covidItem.get(position).getTanggal()+"");
        holder.tvKonfirmasi.setText("Terkonfimasi : "+covidItem.get(position).getCONFIRMATION()+"");
        holder.tvSembuh.setText("Sembuh : "+covidItem.get(position).getConfirmationSelesai()+"");
        holder.tvMeninggal.setText("Meninggal : "+covidItem.get(position).getConfirmationMeninggal()+"");
    }

    @Override
    public int getItemCount() {
        return covidItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggal, tvKonfirmasi, tvSembuh, tvMeninggal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.tanggal);
            tvKonfirmasi = itemView.findViewById(R.id.itemcase_konfirmasi);
            tvSembuh = itemView.findViewById(R.id.itemcase_sembuh);
            tvMeninggal = itemView.findViewById(R.id.itemcase_meninggal);
        }
    }
}
