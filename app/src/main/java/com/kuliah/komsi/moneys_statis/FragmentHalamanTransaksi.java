package com.kuliah.komsi.moneys_statis;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHalamanTransaksi extends Fragment {
    private String[] namaTransaksiArray;
    private String[] nominalTransaksiArray;
    private String[] tanggalTransaksiArray;
    private TypedArray ikonTransaksiArray;
    private TransaksiAdapter adapter;
    private ArrayList<Transaksi> transaksis;
    private ImageButton tambahTransaksi;

    //Month Year Picker
    String monthYearStr;
    private TextView bulanTahun;
    private ImageButton tanggalTransaksi;
    SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");
    SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");

    public FragmentHalamanTransaksi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View view = inflater.inflate(R.layout.fragment_halaman_transaksi, container, false);
        tambahTransaksi = view.findViewById(R.id.tambah_transaksi);
        tambahTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ActivityTambahTransaksi.class);
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

        adapter = new TransaksiAdapter(getActivity());
        ListView listView = view.findViewById(R.id.list_transaksi);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ActivityEditTransaksi.class);
                startActivity(intent);
                Toast.makeText(getActivity(), transaksis.get(i).getNama(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void addItem(){
        transaksis = new ArrayList<>();
        for(int i = 0; i< namaTransaksiArray.length;i++){
            Transaksi transaksi = new Transaksi();
            transaksi.setPhoto(ikonTransaksiArray.getResourceId(i, -1));
            transaksi.setNama(namaTransaksiArray[i]);
            transaksi.setNominal(nominalTransaksiArray[i]);
            transaksi.setTanggal(tanggalTransaksiArray[i]);
            transaksis.add(transaksi);
        }
        adapter.setTransaksis(transaksis);
    }

    private void prepare(){
        namaTransaksiArray = getResources().getStringArray(R.array.nama_transaksi_array);
        nominalTransaksiArray = getResources().getStringArray(R.array.nominal_transaksi_array);
        tanggalTransaksiArray = getResources().getStringArray(R.array.tanggal_transaksi_array);
        ikonTransaksiArray = getResources().obtainTypedArray(R.array.ikon_transaksi_array);
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
