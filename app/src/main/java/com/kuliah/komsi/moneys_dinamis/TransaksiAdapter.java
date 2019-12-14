package com.kuliah.komsi.moneys_dinamis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TransaksiAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Transaksi> transaksis;

    public TransaksiAdapter(Context context) {
        this.context = context;
        transaksis = new ArrayList<>();
    }

    public void setTransaksis(ArrayList<Transaksi> transaksis) {
        this.transaksis = transaksis;
    }

    @Override
    public int getCount() {
        return transaksis.size();
    }

    @Override
    public Object getItem(int i) {
        return transaksis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_transaksi, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Transaksi transaksi = (Transaksi) getItem(i);
        viewHolder.bind(transaksi);
        return view;
    }

    private class ViewHolder{
        private ImageView imgPhoto;
        private TextView txtNama;
        private TextView txtNominal;
        private TextView txtTanggal;


        ViewHolder(View view){
            imgPhoto = view.findViewById(R.id.img_transaksi_photo);
            txtNama = view.findViewById(R.id.tv_item_nama);
            txtNominal = view.findViewById(R.id.tv_item_biaya);
            txtTanggal = view.findViewById(R.id.tv_item_tanggal);
        }

        void bind(Transaksi transaksi){
            imgPhoto.setImageResource(transaksi.getPhoto());
            txtNama.setText(transaksi.getNama());
            txtNominal.setText(transaksi.getNominal());
            txtTanggal.setText(transaksi.getTanggal());
        }
    }
}
