package com.kuliah.komsi.moneys_dinamis;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKategoriPemasukan extends Fragment {
    private String[] kategoriPemasukanArray;
    private TypedArray ikonKategoriPemasukanArray;
    private KategoriAdapter adapter;
    private ArrayList<Kategori> kategoris;
    private LinearLayout klikKategoriPemasukan;
    public static int RESULT_CODE = 110;
    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";

    public FragmentKategoriPemasukan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kategori_pemasukan, container, false);

        /*klikKategoriPemasukan = view.findViewById(R.id.klik_kategori_pemasukan);
        klikKategoriPemasukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ActivityTambahTransaksi.class);
                startActivity(intent);
            }
        });*/
        adapter = new KategoriAdapter(getActivity());
        ListView listView = view.findViewById(R.id.list_kategori_pemasukan);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*Intent resultIntent = new Intent();
                resultIntent.putExtra(kategoris.get(i).getNama(), i);*/
                //Toast.makeText(getActivity(), kategoris.get(i).getNama(), Toast.LENGTH_SHORT).show();
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, kategoris.get(i).getNama());
                getActivity().setResult(RESULT_CODE, resultIntent);
                getActivity().finish();
                getActivity().onBackPressed();
            }
        });
        return view;
    }

    private void addItem(){
        kategoris = new ArrayList<>();

        for(int i = 0; i< kategoriPemasukanArray.length;i++){
            Kategori kategori = new Kategori();
            kategori.setPhoto(ikonKategoriPemasukanArray.getResourceId(i, -1));
            kategori.setNama(kategoriPemasukanArray[i]);
            kategoris.add(kategori);
        }
        adapter.setKategoris(kategoris);
    }

    private void prepare(){
        kategoriPemasukanArray = getResources().getStringArray(R.array.kategori_pemasukan_array);
        ikonKategoriPemasukanArray = getResources().obtainTypedArray(R.array.ikon_kategori_pemasukan_array);
    }

}
