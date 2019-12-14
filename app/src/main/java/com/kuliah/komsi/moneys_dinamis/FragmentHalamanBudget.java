package com.kuliah.komsi.moneys_dinamis;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHalamanBudget extends Fragment {
    private Toolbar mToolbar;
    private ImageButton imageButton;

    //progress bar
    /*int progressColor1;
    int backgroundColor1;
    int max1;
    int progress1;*/

    public FragmentHalamanBudget() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_halaman_budget, container, false);
       /* mToolbar = (Toolbar) view.findViewById(R.id.my_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);*/
        imageButton = view.findViewById(R.id.tambah_transaksi);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ActivityTambahBudget.class);
                startActivity(intent);
            }
        });

        /*RoundCornerProgressBar progress1 = (RoundCornerProgressBar) view.findViewById(R.id.progress_1);
        progress1.setProgressColor(Color.parseColor("#ed3b27"));
        progress1.setProgressBackgroundColor(Color.parseColor("#808080"));
        progress1.setMax(70);
        progress1.setProgress(15);

        int progressColor1 = progress1.getProgressColor();
        int backgroundColor1 = progress1.getProgressBackgroundColor();
        int max1 = (int)progress1.getMax();
        int progress11 = (int)progress1.getProgress();*/

        return view;
    }

}
