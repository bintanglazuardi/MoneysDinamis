package com.kuliah.komsi.moneys_dinamis;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityEditBudget extends AppCompatActivity {
    private EditText inputNama, inputNominal;
    private Button inputKategori;
    private ImageButton hapus;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_budget);
        ActivityEditBudget.this.setTitle("Edit Budget");

        inputNama = findViewById(R.id.input_nama);
        inputNominal = findViewById(R.id.input_nominal);
        inputKategori = findViewById(R.id.input_kategori);
        inputKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent pilihKategori = new Intent(ActivityEditBudget.this ,ActivityPilihKategoriBudget.class);
                startActivity(pilihKategori);*/
                Intent intent = new Intent(ActivityEditBudget.this, ActivityPilihKategoriBudget.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        hapus = findViewById(R.id.hapusEdit);
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityEditBudget.this, "Data dihapus", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == ActivityPilihKategoriBudget.RESULT_CODE){
                //int selectedValue = data.getIntExtra(ActivityPilihKategoriBudget.EXTRA_SELECTED_VALUE, 0);
                String selectedValue = data.getStringExtra(ActivityPilihKategoriBudget.EXTRA_SELECTED_VALUE);
                inputKategori.setText(selectedValue);
                //tvResult.setText(String.format("Hasil : %s",selectedValue));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.save){
            Toast.makeText(this, "Data Disimpan", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
        return true;
    }
}
