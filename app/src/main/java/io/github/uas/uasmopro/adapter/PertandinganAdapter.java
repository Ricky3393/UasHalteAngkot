package io.github.uas.uasmopro.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import io.github.uas.uasmopro.DetailActivity;
import io.github.uas.uasmopro.R;
import io.github.uas.uasmopro.model.Angkot;

public class PertandinganAdapter extends RecyclerView.Adapter<PertandinganAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Angkot> listPertandingan;

    public PertandinganAdapter(Context context, ArrayList<Angkot> listPertandingan){
        this.context = context;
        this.listPertandingan = listPertandingan;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_angkot, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Angkot angkot = listPertandingan.get(position);
        holder.tvJalan.setText(angkot.getRUASJALAN());
        holder.tvLokasi.setText(angkot.getTITIKLOKASI());
        holder.tvKeterangan.setText(""+ angkot.getKETERANGAN());
    }

    @Override
    public int getItemCount() {
        return listPertandingan.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CardView cvAngkot;
        private TextView tvJalan, tvKeterangan, tvLokasi;
        final PertandinganAdapter mAdapter;


        public ViewHolder(View itemView, PertandinganAdapter adapter) {
            super(itemView);

            cvAngkot = itemView.findViewById(R.id.cv_angkot);
            tvJalan = itemView.findViewById(R.id.tv_jalan);
            tvKeterangan = itemView.findViewById(R.id.tv_ket);
            tvLokasi = itemView.findViewById(R.id.tv_lok);

            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            Angkot angkot = listPertandingan.get(mPosition);

            Intent i = new Intent(context, DetailActivity.class);
            i.putExtra("jalan", angkot.getRUASJALAN());
            i.putExtra("lokasi", String.valueOf(angkot.getTITIKLOKASI()));
            i.putExtra("keterangan", angkot.getKETERANGAN());

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            mAdapter.notifyDataSetChanged();

        }
    }


}
