package com.kuliah.komsi.moneys_statis;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapterPilihKategori extends FragmentStatePagerAdapter {
    int behavior;
    public PageAdapterPilihKategori(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.behavior = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentKategoriPemasukan();
            case 1:
                return new FragmentKategoriPengeluaran();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return behavior;
    }
}
