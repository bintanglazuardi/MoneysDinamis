package com.kuliah.komsi.moneys_dinamis;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKategoriPengeluaran extends Fragment {
    private String[] kategoriPengeluaranArray;
    private TypedArray ikonKategoriPengeluaranArray;
    private KategoriAdapter adapter;
    private ArrayList<Kategori> kategoris;
    private LinearLayout klikKategoriPengeluaran;

    public FragmentKategoriPengeluaran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kategori_pengeluaran, container, false);

        klikKategoriPengeluaran = view.findViewById(R.id.klik_kategori_pengeluaran);
        klikKategoriPengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ActivityTambahTransaksi.class);
                startActivity(intent);
            }
        });
        /*adapter = new KategoriAdapter(getActivity());
        ListView listView = view.findViewById(R.id.list_kategori_pengeluaran);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), kategoris.get(i).getNama(),Toast.LENGTH_SHORT).show();
            }
        });*/

        return view;
    }

    private void addItem(){
        kategoris = new ArrayList<>();

        for(int i = 0; i< kategoriPengeluaranArray.length;i++){
            Kategori kategori = new Kategori();
            kategori.setPhoto(ikonKategoriPengeluaranArray.getResourceId(i, -1));
            kategori.setNama(kategoriPengeluaranArray[i]);
            kategoris.add(kategori);
        }
        adapter.setKategoris(kategoris);
    }

    private void prepare(){
        kategoriPengeluaranArray = getResources().getStringArray(R.array.kategori_pemasukan_array);
        ikonKategoriPengeluaranArray = getResources().obtainTypedArray(R.array.ikon_kategori_pemasukan_array);
    }

}
