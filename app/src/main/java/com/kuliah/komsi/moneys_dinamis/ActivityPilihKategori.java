package com.kuliah.komsi.moneys_dinamis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ActivityPilihKategori extends AppCompatActivity {

    public static String EXTRA_KATEGORI = "Belanja";
    public static int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kategori);
        ActivityPilihKategori.this.setTitle("Pilih Kategori");

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        // Create an instance of the tab layout from the view.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText("Pemasukan"));
        tabLayout.addTab(tabLayout.newTab().setText("Pengeluaran"));
        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        getSupportActionBar().hide();

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PageAdapterPilihKategori adapter = new PageAdapterPilihKategori(getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout) {
            private void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            private void onTabUnselected(TabLayout.Tab tab) {

            }

            private void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
