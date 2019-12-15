package com.kuliah.komsi.moneys_dinamis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BudgetTambahAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<BudgetTambah> budgetTambahs;

    public BudgetTambahAdapter(Context context) {
        this.context = context;
        budgetTambahs = new ArrayList<>();
    }

    public void setBudgetTambahs(ArrayList<BudgetTambah> budgetTambahs) {
        this.budgetTambahs = budgetTambahs;
    }

    @Override
    public int getCount() {
        return budgetTambahs.size();
    }

    @Override
    public Object getItem(int i) {
        return budgetTambahs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_budget_tambah, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        BudgetTambah budgetTambah = (BudgetTambah) getItem(i);
        viewHolder.bind(budgetTambah);
        return view;
    }

    private class ViewHolder{
        private ImageView imgPhoto;
        private TextView txtNama;
        private TextView txtNominal;

        ViewHolder(View view){
            imgPhoto = view.findViewById(R.id.ikon_budget_tambah);
            txtNama = view.findViewById(R.id.nama_budget_tambah);
            txtNominal = view.findViewById(R.id.nominal_budget_tambah);
        }

        void bind(BudgetTambah budgetTambah){
            imgPhoto.setImageResource(budgetTambah.getPhoto());
            txtNama.setText(budgetTambah.getNama());
            txtNominal.setText(budgetTambah.getNominal());
        }
    }
}
