package com.kuliah.komsi.moneys_statis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KategoriAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Kategori> kategoris;

    public void setKategoris(ArrayList<Kategori> kategoris) {
        this.kategoris = kategoris;
    }

    public KategoriAdapter(Context context) {
        this.context = context;
        kategoris = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return kategoris.size();
    }

    @Override
    public Object getItem(int i) {
        return kategoris.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_pilih_kategori, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Kategori kategori = (Kategori) getItem(i);
        viewHolder.bind(kategori);
        return view;
    }

    private class ViewHolder{
        private ImageView imgPhoto;
        private TextView txtName;

        ViewHolder(View view){
            imgPhoto = view.findViewById(R.id.img_kategori_photo);
            txtName = view.findViewById(R.id.txt_nama_kategori);
        }

        void bind(Kategori kategori){
            imgPhoto.setImageResource(kategori.getPhoto());
            txtName.setText(kategori.getNama());
        }
    }
}
