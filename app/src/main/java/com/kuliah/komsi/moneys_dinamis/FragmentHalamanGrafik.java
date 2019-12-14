package com.kuliah.komsi.moneys_dinamis;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHalamanGrafik extends Fragment {
    PieChartView pieChartView;
    //Month Year Picker
    String monthYearStr;
    private TextView bulanTahun;
    private ImageButton tanggalTransaksi;
    SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");
    SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");

    public FragmentHalamanGrafik() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_halaman_grafik, container, false);
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

        pieChartView = view.findViewById(R.id.chart);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(11, Color.parseColor("#649BEE")).setLabel("11%"));
        pieData.add(new SliceValue(30, Color.parseColor("#2B48B1")).setLabel("30%"));
        pieData.add(new SliceValue(10, Color.parseColor("#DA777D")).setLabel("10%"));
        pieData.add(new SliceValue(7, Color.parseColor("#37A4C7")).setLabel("7%"));
        pieData.add(new SliceValue(26, Color.parseColor("#C92C64")).setLabel("26%"));
        pieData.add(new SliceValue(16, Color.parseColor("#B87716")).setLabel("16%"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(10);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Grafik").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);

        return view;
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
