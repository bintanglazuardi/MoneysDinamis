package com.kuliah.komsi.moneys_dinamis;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.widget.DatePicker;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDatePickerTambah extends DialogFragment implements
    DatePickerDialog.OnDateSetListener{

    public FragmentDatePickerTambah() {
        // Required empty public constructor
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        ActivityTambahTransaksi activity = (ActivityTambahTransaksi) getActivity();
        activity.processDatePickerResult(year, month, day);
    }

}
