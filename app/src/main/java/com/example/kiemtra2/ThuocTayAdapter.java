package com.example.kiemtra2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class ThuocTayAdapter extends RecyclerView.Adapter<ThuocTayAdapter.ThuocTayViewHolder> {

    Context context;
    List<ThuocTay> thuocTays;
    MainActivity mainActivity = new MainActivity();

    FirebaseFirestore fdb = FirebaseFirestore.getInstance();

    public ThuocTayAdapter(Context context, List<ThuocTay> thuocTays) {
        this.context = context;
        this.thuocTays = thuocTays;
    }

    @NonNull
    @Override
    public ThuocTayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_thuoctay, parent, false);
        return new ThuocTayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThuocTayViewHolder holder, int position) {
        ThuocTay thuocTay = thuocTays.get(position);
        if(thuocTay == null) {
            return;
        }

        holder.tenkhoahoc.setText(thuocTay.getTenkhoahoc());
        holder.dactinh.setText(thuocTay.getDactinh());
        holder.idthuoctay.setText(thuocTay.getIdthuoctay());

        Glide.with(context).load(thuocTay.getHinhanh()).into(holder.hinhanh);
        holder.xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fdb.collection("thuoctay").document(thuocTay.getIdthuoctay()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                    }
                });
            }
        });

        holder.item_thuoctay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("idThuoctay", thuocTay.getIdthuoctay());
                intent.putExtra("thuoctay", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(thuocTays != null) {
            return thuocTays.size();
        }
        return 0;
    }

    public class ThuocTayViewHolder extends RecyclerView.ViewHolder {
        TextView tenkhoahoc, dactinh, idthuoctay;
        ImageView hinhanh;
        Button xoa;
        LinearLayout item_thuoctay;
        public ThuocTayViewHolder(@NonNull View itemView) {
            super(itemView);
            tenkhoahoc = itemView.findViewById(R.id.tenkhoahoc);
            dactinh = itemView.findViewById(R.id.dactinh);
            hinhanh = itemView.findViewById(R.id.hinhanh);
            xoa = itemView.findViewById(R.id.xoa);
            item_thuoctay = itemView.findViewById(R.id.item_thuoctay);
            idthuoctay = itemView.findViewById(R.id.idthuoctay);
        }
    }
}
