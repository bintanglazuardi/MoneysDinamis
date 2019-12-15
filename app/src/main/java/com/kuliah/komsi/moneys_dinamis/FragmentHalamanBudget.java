package com.kuliah.komsi.moneys_dinamis;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHalamanBudget extends Fragment {
    private String[] namaBudgetArray;
    private String[] nominalBudgetArray;
    private TypedArray progressBarBudgetArray;
    private TypedArray ikonBudgetArray;
    private BudgetAdapter adapter;
    private ArrayList<Budget> budgets;
    private ImageButton imageButton;

    private RelativeLayout budget11;

    //progress bar
    /*int progressColor1;
    int backgroundColor1;
    int max1;
    int progress1;*/

    //Month Year Picker
    String monthYearStr;
    private TextView bulanTahun;
    private ImageButton tanggalTransaksi;
    SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");
    SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");

    public FragmentHalamanBudget() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_halaman_budget, container, false);
       /* mToolbar = (Toolbar) view.findViewById(R.id.my_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);*/
        imageButton = view.findViewById(R.id.tambah_transaksi);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ActivityTambahBudget.class);
                startActivity(intent);
            }
        });

        bulanTahun = view.findViewById(R.id.bulan_tahun);
        tanggalTransaksi = view.findViewById(R.id.tanggal_transaksi);
        tanggalTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentMonthYearPickerDialog pickerDialog = new FragmentMonthYearPickerDialog();
                pickerDialog.setListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int i2) {
                        monthYearStr = year + "-" + (month + 1) + "-" + i2;
                        bulanTahun.setText(formatMonthYear(monthYearStr));
                    }
                });
                //pickerDialog.show(getSupportFragmentManager(), "FragmentMonthYearPickerDialog");
                pickerDialog.show(getFragmentManager(), "FragmentMonthYearPickerDialog");
            }
        });

        budget11 = view.findViewById(R.id.budget1);
        budget11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ActivityEditBudget.class);
                startActivity(intent);
            }
        });

        /*adapter = new BudgetAdapter(getActivity());
        ListView listView = view.findViewById(R.id.list_budget);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ActivityEditBudget.class);
                startActivity(intent);
                Toast.makeText(getActivity(), budgets.get(i).getNama(),Toast.LENGTH_SHORT).show();
            }
        });*/

        /*RoundCornerProgressBar progress1 = (RoundCornerProgressBar) view.findViewById(R.id.progress_1);
        progress1.setProgressColor(Color.parseColor("#ed3b27"));
        progress1.setProgressBackgroundColor(Color.parseColor("#808080"));
        progress1.setMax(70);
        progress1.setProgress(15);

        int progressColor1 = progress1.getProgressColor();
        int backgroundColor1 = progress1.getProgressBackgroundColor();
        int max1 = (int)progress1.getMax();
        int progress11 = (int)progress1.getProgress();*/

        return view;
    }

    private void addItem(){
        budgets = new ArrayList<>();
        for(int i = 0; i< namaBudgetArray.length;i++){
            Budget budget = new Budget();
            budget.setPhoto(ikonBudgetArray.getResourceId(i, -1));
            budget.setNama(namaBudgetArray[i]);
            budget.setSisa(nominalBudgetArray[i]);
            //budget.setProgressBar(progressBarBudgetArray.getResourceId(i, -1));
            budgets.add(budget);
        }
        adapter.setBudgets(budgets);
    }

    private void prepare(){
        namaBudgetArray = getResources().getStringArray(R.array.nama_budget_array);
        nominalBudgetArray = getResources().getStringArray(R.array.sisa_budget_array);
        ikonBudgetArray = getResources().obtainTypedArray(R.array.ikon_budget_array);
    }

    String formatMonthYear(String str) {
        Date date = null;
        try {
            date = input.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(date);
    }

}
