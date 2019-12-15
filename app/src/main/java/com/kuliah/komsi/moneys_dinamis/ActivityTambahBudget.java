package com.kuliah.komsi.moneys_dinamis;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityTambahBudget extends AppCompatActivity {
    private Button tambahKategori;
    private Button tambahBudget;
    private String[] namaBudgetTambahArray;
    private String[] nominalBudgetTambahArray;
    private TypedArray ikonBudgetTambahArray;
    private BudgetTambahAdapter adapter;
    private ArrayList<BudgetTambah> budgetTambahs;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_budget);
        ActivityTambahBudget.this.setTitle("Tambah Budget");

        tambahBudget = findViewById(R.id.tambah_budget);
        tambahBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityTambahBudget.this, "Berhasil menambahkan budget", Toast.LENGTH_SHORT).show();
            }
        });

        tambahKategori = findViewById(R.id.input_kategori);
        tambahKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTambahBudget.this, ActivityPilihKategoriBudget.class);
                startActivityForResult(intent, REQUEST_CODE);
                //startActivity(intent);
            }
        });

        /*adapter = new BudgetTambahAdapter(this);
        ListView listView = findViewById(R.id.list_budget_tambah);
        listView.setAdapter(adapter);
        prepare();
        addItem();*/
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ActivityEditBudget.class);
                startActivity(intent);
                Toast.makeText(getActivity(), budgets.get(i).getNama(),Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == ActivityPilihKategoriBudget.RESULT_CODE){
                //int selectedValue = data.getIntExtra(ActivityPilihKategoriBudget.EXTRA_SELECTED_VALUE, 0);
                String selectedValue = data.getStringExtra(ActivityPilihKategoriBudget.EXTRA_SELECTED_VALUE);
                tambahKategori.setText(selectedValue);
                //tvResult.setText(String.format("Hasil : %s",selectedValue));
            }
        }
    }

    private void addItem(){
        budgetTambahs = new ArrayList<>();
        for(int i = 0; i< namaBudgetTambahArray.length;i++){
            BudgetTambah budgetTambah = new BudgetTambah();
            budgetTambah.setPhoto(ikonBudgetTambahArray.getResourceId(i, -1));
            budgetTambah.setNama(namaBudgetTambahArray[i]);
            budgetTambah.setNominal(nominalBudgetTambahArray[i]);
            budgetTambahs.add(budgetTambah);
        }
        adapter.setBudgetTambahs(budgetTambahs);
    }

    private void prepare(){
        namaBudgetTambahArray = getResources().getStringArray(R.array.nama_budget_array);
        nominalBudgetTambahArray = getResources().getStringArray(R.array.nominal_budget_array);
        ikonBudgetTambahArray = getResources().obtainTypedArray(R.array.ikon_budget_array);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.save){
            Toast.makeText(this, "Data Disimpan", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
        return true;
    }*/
}
