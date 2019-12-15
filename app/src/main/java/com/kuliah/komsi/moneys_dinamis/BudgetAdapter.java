package com.kuliah.komsi.moneys_dinamis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import java.util.ArrayList;

public class BudgetAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Budget> budgets;

    public BudgetAdapter(Context context) {
        this.context = context;
        budgets = new ArrayList<>();
    }

    public void setBudgets(ArrayList<Budget> budgets) {
        this.budgets = budgets;
    }
    @Override
    public int getCount() {
        return budgets.size();
    }

    @Override
    public Object getItem(int i) {
        return budgets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_budget, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Budget budget = (Budget) getItem(i);
        viewHolder.bind(budget);
        return view;
    }

    private class ViewHolder{
        private ImageView imgPhoto;
        private TextView txtNama;
        private TextView txtNominal;
        //private RoundCornerProgressBar progressBar;

        ViewHolder(View view){
            imgPhoto = view.findViewById(R.id.ikon_budget);
            txtNama = view.findViewById(R.id.nama_budget);
            txtNominal = view.findViewById(R.id.nominal_budget);
            //progressBar = view.findViewById(R.id.progress_bar_budget);
        }

        void bind(Budget budget){
            imgPhoto.setImageResource(budget.getPhoto());
            txtNama.setText(budget.getNama());
            txtNominal.setText(budget.getSisa());
            //progressBar.setProgress(budget.getProgressBar());
        }
    }
}
