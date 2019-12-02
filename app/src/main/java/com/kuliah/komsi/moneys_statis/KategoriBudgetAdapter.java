package com.kuliah.komsi.moneys_statis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KategoriBudgetAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<KategoriBudget> kategoriBudgets;

    public KategoriBudgetAdapter(Context context) {
        this.context = context;
        kategoriBudgets = new ArrayList<>();
    }

    public void setKategoriBudgets(ArrayList<KategoriBudget> kategoriBudgets) {
        this.kategoriBudgets = kategoriBudgets;
    }

    @Override
    public int getCount() {
        return kategoriBudgets.size();
    }

    @Override
    public Object getItem(int i) {
        return kategoriBudgets.get(i);
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
        KategoriBudget kategoriBudget = (KategoriBudget) getItem(i);
        viewHolder.bind(kategoriBudget);
        return view;
    }

    private class ViewHolder{
        private ImageView imgPhoto;
        private TextView txtName;

        ViewHolder(View view){
            imgPhoto = view.findViewById(R.id.img_kategori_photo);
            txtName = view.findViewById(R.id.txt_nama_kategori);
        }

        void bind(KategoriBudget kategoriBudget){
            imgPhoto.setImageResource(kategoriBudget.getPhoto());
            txtName.setText(kategoriBudget.getNama());
        }
    }
}
