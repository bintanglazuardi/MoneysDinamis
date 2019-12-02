package com.kuliah.komsi.moneys_statis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityPilihKategoriBudget extends AppCompatActivity {
    private String[] kategoriPengeluaranArray;
    private TypedArray ikonKategoriPengeluaranArray;
    private KategoriBudgetAdapter adapter;
    private ArrayList<KategoriBudget> kategoriBudgets;
    private LinearLayout klikKategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kategori_budget);
        ActivityPilihKategoriBudget.this.setTitle("Pilih Kategori");

        klikKategori = findViewById(R.id.klik_kategori);
        klikKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

       /* adapter = new KategoriBudgetAdapter(this);
        ListView listView = findViewById(R.id.list_kategori_pengeluaran);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityPilihKategoriBudget.this,
                        kategoriBudgets.get(i).getNama(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    private void addItem(){
        kategoriBudgets = new ArrayList<>();

        for(int i = 0; i< kategoriPengeluaranArray.length;i++){
            KategoriBudget kategoriBudget = new KategoriBudget();
            kategoriBudget.setPhoto(ikonKategoriPengeluaranArray.getResourceId(i, -1));
            kategoriBudget.setNama(kategoriPengeluaranArray[i]);
            kategoriBudgets.add(kategoriBudget);
        }
        adapter.setKategoriBudgets(kategoriBudgets);
    }

    private void prepare(){
        kategoriPengeluaranArray = getResources().getStringArray(R.array.kategori_pemasukan_array);
        ikonKategoriPengeluaranArray = getResources().obtainTypedArray(R.array.ikon_kategori_pemasukan_array);
    }

}
