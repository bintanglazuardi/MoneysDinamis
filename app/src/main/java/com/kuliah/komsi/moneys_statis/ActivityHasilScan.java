package com.kuliah.komsi.moneys_statis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityHasilScan extends AppCompatActivity {
    private Button btnScan;
    private TextView inputTanggal;
    private EditText inputNama, inputNominal;
    private Button inputKategori;
    public static LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_scan);
        ActivityHasilScan.this.setTitle("Tambah Transaksi");

        /*linearLayout = findViewById(R.id.hasil_scan_nota);

        btnScan = findViewById(R.id.scanNota);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scanPage = new Intent(ActivityHasilScan.this, ActivityScan.class);
                startActivity(scanPage);
            }
        });
        inputNama = findViewById(R.id.input_nama);
        inputNominal = findViewById(R.id.input_nominal);
        inputTanggal = findViewById(R.id.input_tanggal);
        inputKategori = findViewById(R.id.input_kategori);
        inputKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pilihKategori = new Intent(ActivityHasilScan.this ,ActivityPilihKategori.class);
                startActivity(pilihKategori);
            }
        });*/
    }

    @Override
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
            Intent intent = new Intent(ActivityHasilScan.this, MainActivity.class);
            startActivity(intent);
        }
        return true;
    }

    /*public void ShowDatePickerDialog(View v) {
        DialogFragment newFragment = new FragmentDatePickerTambah();
        newFragment.show(getSupportFragmentManager(), "Date Picker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string="default";
        if (month+1%12==1){
            month_string = "Januari";
        }else if(month+1%12==2){
            month_string = "Februari";
        }else if(month+1%12==3){
            month_string = "Maret";
        }else if(month+1%12==4){
            month_string = "April";
        }else if(month+1%12==5){
            month_string = "Mei";
        }else if(month+1%12==6){
            month_string = "Juni";
        }else if(month+1%12==7){
            month_string = "Juli";
        }else if(month+1%12==8){
            month_string = "Agustus";
        }else if(month+1%12==9){
            month_string = "September";
        }else if(month+1%12==10){
            month_string = "Oktober";
        }else if(month+1%12==11){
            month_string = "November";
        }else if(month+1%12==12){
            month_string = "Desember";
        }

        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (day_string + " " + month_string + " " + year_string);
        inputTanggal.setText(dateMessage);
    }*/
}
