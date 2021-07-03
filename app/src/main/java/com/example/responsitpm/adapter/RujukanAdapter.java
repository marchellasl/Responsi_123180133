package com.example.responsitpm.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsitpm.R;
import com.example.responsitpm.model.rujukan.RujukanDataItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RujukanAdapter extends RecyclerView.Adapter<RujukanAdapter.ViewHolder>{

    private ArrayList<RujukanDataItem> rujukanItem = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<RujukanDataItem> items) {
        rujukanItem.clear();
        rujukanItem.addAll(items);
        notifyDataSetChanged();
    }

    public RujukanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNama.setText(rujukanItem.get(position).getNama());
        holder.tvAlamat.setText(rujukanItem.get(position).getAlamat());
        holder.btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q="+ rujukanItem.get(position).getAlamat()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rujukanItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat;
        Button btnMaps;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.itemrujuk_nama);
            tvAlamat = itemView.findViewById(R.id.itemrujuk_alamat);
            btnMaps = itemView.findViewById(R.id.itemrujuk_btnmaps);
        }
    }
}
