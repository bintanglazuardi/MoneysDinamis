package com.kuliah.komsi.moneys_dinamis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityTambahBudget extends AppCompatActivity {
    private Button tambahKategori;
    private Button tambahBudget;

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
                startActivity(intent);
            }
        });
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
